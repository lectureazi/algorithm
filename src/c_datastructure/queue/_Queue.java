package c_datastructure.queue;

import c_datastructure.Node;

import java.util.Iterator;

public class _Queue<E> implements Iterable<E>{

    private Node<E> top;
    private Node<E> cacheNode;
    private int size;

    public int size() {
        return size;
    }

    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        if (top == null) {
            top = newNode;
            cacheNode = newNode;
            size++;
            return;
        }

        cacheNode.next(newNode);
        cacheNode = newNode;
        size++;
    }

    public E dequeue() {
        if (top == null) return null;
        E res = top.data();
        top = top.next();
        size--;
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<E> link = top;
        if(link == null) return "[]";

        sb.append("[");
        while(link != null) {
            sb.append(link.data());
            sb.append(", ");
            link = link.next();
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> pointer = top;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                E res = pointer.data();
                pointer = pointer.next();
                return res;
            }
        };
    }
}
