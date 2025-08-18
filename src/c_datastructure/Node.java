package c_datastructure;

public class Node<E> {
	
	private Node<E> next;
	private E data;
	
	public Node(E data) {
		super();
		this.data = data;
	}

	public Node<E> next(){
		return next;
	}
	
	public void next(Node<E> next){
		this.next = next;
	}
	
	public E data() {
		return data;
	}
	
	public void data(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}
