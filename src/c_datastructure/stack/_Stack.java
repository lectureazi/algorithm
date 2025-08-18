package c_datastructure.stack;

import c_datastructure.Node;

import java.util.Iterator;

public class _Stack<E> implements Iterable<E> {

    private Node<E> top;
    private int size;

    public void push(E e) {
        Node<E> newNode = new Node<>(e);

        if (top != null) {
            newNode.next(top);
        }

        top = newNode;
        size++;
    }

    public E pop() {
        if(top == null) return null;
        E res = top.data();
        top = top.next();
        size--;
        return res;
    }

    public E peek() {
        if(top == null) return null;
        return top.data();
    }

    public boolean isEmpty() {
        return size == 0;
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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (E e : this) {
            sb.append(e);
            sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }
}
