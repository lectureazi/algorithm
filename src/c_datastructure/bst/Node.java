package c_datastructure.bst;

public class Node<E> {

    E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
