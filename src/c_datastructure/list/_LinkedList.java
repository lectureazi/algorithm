package c_datastructure.list;

import c_datastructure.Node;

import java.util.Iterator;

public class _LinkedList<E> implements Iterable<E>{
	
	private Node<E> head;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean add(E e) {
		
		Node<E> node = new Node<>(e);
		
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
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		
		Node<E> link = head;
		for (int i = 0; i < index; i++) {
			link = link.next();
		}
		
		return link.data();
	}
	
	
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		
		Node<E> link = head;
		for (int i = 0; i < index; i++) {
			link = link.next();
		}
		
		E removed = link.data();
		link.data(element);
		return removed;
	}
	
	
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
		
		if(index == 0) {
			E removed = head.data();
			head = head.next();
			size--;
			return removed;
		}
		
		Node<E> prevNode = head;
		Node<E> link = head.next();
		
		for (int i = 1; i < index; i++) {
			prevNode = link;
			link = link.next();
		}
		
		prevNode.next(link.next());
		E removed = link.data();
		size--;
		return removed;
	}
	
	@Override
	public String toString() {
		
		if(size == 0) return null;
		StringBuffer sb = new StringBuffer("[");
		
		for (int i = 0; i < size; i++) {
			sb.append(get(i));
			sb.append(", ");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		return sb.toString();
	}
	
	// iterator
	
	// contains
	public boolean contains(Object e) {
		Node<E> link = head;
		
		while(link != null) {
			if(link.data().equals(e)) return true;
			link = link.next();
		}
		
		return false;
	}
	
	// indexOf
	public int indexOf(Object e) {
		Node<E> link = head;
		
		for (int i = 0; i < size; i++) {
			if(link.data().equals(e)) return i;
			link = link.next();
		}
		
		return -1;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			private Node<E> pointer = head;
			
			@Override
			public boolean hasNext() {
				return pointer != null;
			}
			
			@Override
			public E next() {
				E  e = pointer.data();
				pointer = pointer.next();
				return e;
			}
		};
	}
	
	
	
}
