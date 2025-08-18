package c_datastructure.list;

import c_datastructure.Node;

import java.util.Iterator;

public class _LinkedList<E> implements Iterable<E> {
	
	private Node<E> head;
	private int size;
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size <= 0;
	}
	
	//C
	public boolean add(E e) {
		Node<E> node = new Node<E>(e);
		
		if(head == null) {
			head = node;
			size++;
			return true;
		}
		
		Node<E> link = head;
		
		while(link.next() != null) {
			link = link.next();
		}
		
		link.next(node);
		size++;
		return true;
	}
	
	//R
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node<E> link = head;
		for (int i = 0; i < index; i++) {
			link = link.next();
		}
		
		return link.data();
	}
	
	//U
	public E set(int index, E e) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node<E> link = head;
		for (int i = 0; i < index; i++) {
			link = link.next();
		}
		
		E prev = link.data();
		link.data(e);
		return prev;
	}
	
	//D
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node<E> link = head;
		Node<E> prevNode = head;
		for (int i = 0; i < index; i++) {
			prevNode = link;
			link = link.next();
		}
		
		prevNode.next(link.next());
		E prev = link.data();
		size--;
		return prev;
	}

	public boolean contains(E e){
		Node<E> link = head;
		while(link != null) {
			if(link.data().equals(e)) {
				return true;
			}
			link = link.next();
		}

		return false;
	}

	public int indexOf(E e){
		Node<E> link = head;
		for(int i = 0; i < size; i++) {
			if(link.data().equals(e)) return i;
			link = link.next();
		}

		return -1;
	}
	
	//toString
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer("[");
		
		for (int i = 0; i < size; i++) {
			sb.append(get(i));
			if(i == size-1) break;
			sb.append(", ");
		}
		
		sb.append(" ]");
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		//익명클래스
		return new Iterator<E>() {
			private int pointer;

			@Override
			public boolean hasNext() {
				return pointer < size();
			}

			@Override
			public E next() {
				E e = get(pointer);
				pointer++;
				return e;
			}
		};
	}
}
