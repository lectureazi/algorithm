package c_datastructure.bst;

import c_datastructure.list._LinkedList;
import c_datastructure.queue._Queue;
import c_datastructure.stack._Stack;

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

    public void inOrder(){
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
        };

        for (Node<E> node : list) {
            System.out.print(node.data + " ");
        }
    }

    public void preOrder(){
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

        for (Node<E> node : list) {
            System.out.println(node);
        }
    }

    public void postOrder(){
        _Stack<Node<E>> stack = new _Stack<>();
        _Stack<Node<E>> elements = new _Stack<>();

        stack.push(root);

        while (true) {
            if(stack.isEmpty()) break;

            Node<E> pointer = stack.pop();
            elements.push(pointer);

            if (pointer.getLeft() != null) {
                stack.push(pointer.getLeft());
            }

            if (pointer.getRight() != null) {
                stack.push(pointer.getRight());
            }
        }

        for (Node<E> element : elements) {
            System.out.println(element);
        }
    }

    public void bfs(){
        _Queue<Node<E>> queue = new _Queue<>();
        queue.enqueue(root);
        int level = 0;

        while(!queue.isEmpty()){
            System.out.print("level " + level + ": ");
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node<E> node = queue.dequeue();
                System.out.print(node.data + " ");

                if(node.getLeft() != null){
                    queue.enqueue(node.getLeft());
                }

                if(node.getRight() != null){
                    queue.enqueue(node.getRight());
                }
            }

            System.out.println();
            level++;
        }
    }
}
