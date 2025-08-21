package c_datastructure.bst;

import c_datastructure.list._LinkedList;
import c_datastructure.queue._Queue;
import c_datastructure.stack._Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public int size() {
        return size;
    }

    public void insert(E element) {
        Node<E> newNode = new Node<>(element);

        if(root == null) {
            root = newNode;
            size++;
            return;
        }

        Node<E> link = root;
        while(true){
            if(element.compareTo(link.data) < 0) {
                if(link.getLeft() == null){
                    link.setLeft(newNode);
                    break;
                }
                link = link.getLeft();
            } else{
                if(link.getRight() == null){
                    link.setRight(newNode);
                    break;
                }

                link = link.getRight();
            }
        }

        size++;
    }

    public Node<E> findNode(E element) {
        Node<E> link = root;

        while(true){

            if(link == null) return null;

            if(element.compareTo(link.data) == 0) {
                return link;
            }

            if(element.compareTo(link.data) < 0) {
                link = link.getLeft();
            }

            if(element.compareTo(link.data) > 0) {
                link = link.getRight();
            }
        }
    }
    
    // 노드 삭제
    public boolean deleteNode(E targetData) {
        if (root == null) {
            return false;
        }
        
        Node<E> targetNode = null;
        Node<E> deepestNode = null;
        Node<E> parentOfDeepestNode = null;
        
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();
            if (current.data.equals(targetData)) {
                targetNode = current;
            }
            deepestNode = current;
            
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
                if (current.getLeft() == deepestNode) {
                    parentOfDeepestNode = current;
                }
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
                if (current.getRight() == deepestNode) {
                    parentOfDeepestNode = current;
                }
            }
        }
        
        if (targetNode == null) {
            System.out.println("Node with data " + targetData + " not found.");
            return false;
        }
        
        if (targetNode == root) {
            if (deepestNode == root) {
                root = null;
            } else {
                root.data = deepestNode.data;
                if (parentOfDeepestNode.getLeft() == deepestNode) {
                    parentOfDeepestNode.setLeft(null);
                } else {
                    parentOfDeepestNode.setRight(null);
                }
            }
        } else {
            targetNode.data = deepestNode.data;
            if (parentOfDeepestNode.getLeft() == deepestNode) {
                parentOfDeepestNode.setLeft(null);
            } else {
                parentOfDeepestNode.setRight(null);
            }
        }
        System.out.println("Node with data " + targetData + " deleted.");
        return true;
    }
    
    
    // dfs : 깊이 우선 탐색
    //        하나의 경로를 최대한 깊숙이 따라 들어간 후,
    //        더 이상 탐색할 수 없는 곳에 도달하면 되돌아와서(백트래킹) 다른 경로를 탐색
    // 이벤트 캡처링, 이벤트 버블링
    public List<E> inOrderRecursive() {
        List<E> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }
    
    private void inOrderHelper(Node<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.getLeft(), result);
        result.add(node.data);
        inOrderHelper(node.getRight(), result);
    }

    public _LinkedList<Node<E>> inOrder(){
        _Stack<Node<E>> stack = new _Stack<>();
        _LinkedList<Node<E>> list = new _LinkedList<>();
        Node<E> pointer = root;

        while(pointer != null || !stack.isEmpty()){
            while(pointer != null) {
                stack.push(pointer);
                pointer = pointer.getLeft();
            };

            pointer = stack.pop();
            list.add(pointer);
            pointer = pointer.getRight();
        }

        return list;
    }
    
    public List<E> preOrderRecursive() {
        List<E> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }
    
    private void preOrderHelper(Node<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);          // 현재 노드 추가
        preOrderHelper(node.getLeft(), result);    // 왼쪽 자식 순회
        preOrderHelper(node.getRight(), result);   // 오른쪽 자식 순회
    }

    public _LinkedList<Node<E>> preOrder(){
        _Stack<Node<E>> stack = new _Stack<>();
        _LinkedList<Node<E>> list = new _LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<E> pointer = stack.pop();
            list.add(pointer);

            if (pointer.getRight() != null) {
                stack.push(pointer.getRight());
            }

            if (pointer.getLeft() != null) {
                stack.push(pointer.getLeft());
            }
        }

        return list;
    }
    
    public List<E> postOrderRecursive() {
        List<E> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }
    
    private void postOrderHelper(Node<E> node, List<E> result) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.getLeft(), result);   // 왼쪽 자식 순회
        postOrderHelper(node.getRight(), result);  // 오른쪽 자식 순회
        result.add(node.data);         // 현재 노드 추가
    }

    public _Stack<Node<E>> postOrder(){
        _Stack<Node<E>> stack = new _Stack<>();
        _Stack<Node<E>> elements = new _Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node<E> pointer = stack.pop();
            
            if (pointer.getLeft() != null) {
                stack.push(pointer.getLeft());
            }
            
            if (pointer.getRight() != null) {
                stack.push(pointer.getRight());
            }
            
            elements.push(pointer);
        }
        return elements;
    }
    
    // bfs(Breadth-First Search) : 너비 우선 탐색
    // 현재 노드와 인접한 모든 노드를 먼저 탐색한 후, 그 다음 레벨의 노드들을 탐색하는 방식
    // DB B+트리 인덱스 데이터
    public _LinkedList<E> bfs(){
        _Queue<Node<E>> queue = new _Queue<>();
        _LinkedList<E> result = new _LinkedList<>();
        queue.enqueue(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node<E> node = queue.dequeue();
                result.add(node.data);

                if(node.getLeft() != null){
                    queue.enqueue(node.getLeft());
                }

                if(node.getRight() != null){
                    queue.enqueue(node.getRight());
                }
            }
        }
        
        return result;
    }
    
//    public boolean delete(E data) {
//        Node<E> parent = null;
//        Node<E> current = root;
//
//        // 삭제할 노드와 부모 노드 찾기
//        while (current != null && data.compareTo(current.data) != 0) {
//            parent = current;
//            if (data.compareTo(current.data) < 0) {
//                current = current.left;
//            } else {
//                current = current.right;
//            }
//        }
//
//        if (current == null) {
//            // 삭제할 노드를 찾지 못함
//            System.out.println("Node with data " + data + " not found.");
//            return false;
//        }
//
//        // Case 1: 자식 노드가 없는 경우 (리프 노드)
//        if (current.left == null && current.right == null) {
//            if (current == root) {
//                root = null;
//            } else if (parent.left == current) {
//                parent.left = null;
//            } else {
//                parent.right = null;
//            }
//        }
//
//        // Case 2: 자식 노드가 하나만 있는 경우
//        else if (current.left == null) {
//            if (current == root) {
//                root = current.right;
//            } else if (parent.left == current) {
//                parent.left = current.right;
//            } else {
//                parent.right = current.right;
//            }
//        }
//        else if (current.right == null) {
//            if (current == root) {
//                root = current.left;
//            } else if (parent.left == current) {
//                parent.left = current.left;
//            } else {
//                parent.right = current.left;
//            }
//        }
//
//        // Case 3: 자식 노드가 두 개 있는 경우
//        else {
//            Node<E> successorParent = current;
//            Node<E> successor = current.right;
//
//            // 오른쪽 서브트리에서 가장 작은 값(후계자) 찾기
//            while (successor.left != null) {
//                successorParent = successor;
//                successor = successor.left;
//            }
//
//            // 후계자 데이터를 현재 노드로 복사
//            current.data = successor.data;
//
//            // 후계자 노드 삭제
              // 후계자 노드는 오른쪽자식노드만 존재.
              // 후계자 부모노드 위치에 오른쪽 자식노드를 삽입. 오른쪽 자식노드가 없으면 null 이 들어감
//            if (successorParent.left == successor) {
//                successorParent.left = successor.right;
//            } else {
                  // 오른쪽 서브트리에 노드가 하나만 있는 경우
//                successorParent.right = successor.right;
//            }
//        }
//
//        System.out.println("Node with data " + data + " deleted.");
//        return true;
//    }
}
