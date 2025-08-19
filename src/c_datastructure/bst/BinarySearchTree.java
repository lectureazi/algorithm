package c_datastructure.bst;

import c_datastructure.list._LinkedList;
import c_datastructure.queue._Queue;
import c_datastructure.stack._Stack;
import java.util.ArrayList;
import java.util.List;

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

    public boolean find(E element) {
        Node<E> link = root;

        while(true){

            if(link == null) return false;

            if(element.compareTo(link.data) == 0) {
                return true;
            }

            if(element.compareTo(link.data) < 0) {
                link = link.getLeft();
            }

            if(element.compareTo(link.data) > 0) {
                link = link.getRight();
            }
        }
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
    
    // bfs(Breadth-First Search) : 넓이 우선 탐색
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
}
