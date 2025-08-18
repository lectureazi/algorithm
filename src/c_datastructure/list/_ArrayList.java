package c_datastructure.list;

import java.util.Arrays;
import java.util.Iterator;

// interface
// inter(사이) + face(면)
// ex) UI : user interface
//			사용자와 프로그램이 만나는 접점의 약속

// generic
// 제네릭은 모든 알파벳으로 지정할 수 있다.
// E : Element, 배열기반 구조에서 요소를 의미
// T : 일반적인 Type
// K : key
// V : value

// <K, V> : 제네릭은 여러개 지정할 수 있다.
// <? extends T> : T를 구현또는 상속하고 있는 타입이 제네릭으로 지정되어야 함
// <? super T>   : T의 부모, 선조 타입
@SuppressWarnings("unchecked")
public class _ArrayList<E> implements Iterable<E> {
	
	private Object[] elementData;
	public int size;
	public static int staticVal = 100;
	private int arraySize = 10;
	
	public _ArrayList() {
		elementData = new Object[arraySize];
	}
	
	public _ArrayList(int capacity) {
		super();
		this.arraySize = capacity;
		elementData = new Object[arraySize];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size <= 0;
	}

	// C
	public boolean add(E e) {
		
		// elementData에 공간이 있다면
		if(size < arraySize) {
			elementData[size] = e;
			size++;
			return true;
		}
		
		arraySize *= 2;
		Object[] tempArr = new Object[arraySize];
		
		for (int i = 0; i < size; i++) {
			tempArr[i] = elementData[i];
		}
		
		tempArr[size] = e;
		size++;
		
		elementData = tempArr;
		return true;
	}
	
	// R
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스의 범위를 벗어났습니다.");
		}
		return (E) elementData[index];
	}
	
	// U
	public E set(int index, E e) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스의 범위를 벗어났습니다.");
		}
		
		E prev = (E) elementData[index];
		elementData[index] = e;
		return prev;
	}
	
	// D
	public E remove(int index) {
		
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("인덱스의 범위를 벗어났습니다.");
		}
		
		E prev = (E) elementData[index];
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i+1];
		}
		
		elementData[size - 1] = null;
		size--;
		return prev;
		
	}

	@Override
	public String toString() {
		return "_ArrayList [elementData=" + Arrays.toString(elementData) + ", size=" + size + ", arraySize=" + arraySize
				+ "]";
	}

	// 제어반전
	// 사용자가 작성한 코드를 사용자가 아닌 외부모듈이 호출하는 것
	// 라이브러리와 프레임워크의 차이를 결정
	// 제어(흐름)을 개발자가 결정하느냐, 프레임워크가 결정하느냐에 있어서 프레임워크는 제어반전의 특성을 가지기
	// 때문에 프레임워크가 흐름을 결정함
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
	
	// 내부클래스
	public class _Iterator implements Iterator<E>{
		
		private int pointer;

		@Override
		public boolean hasNext() {
			System.out.printf("hasNext %s \n", pointer < size());
			return pointer < size();
		}

		@Override
		public E next() {
			System.out.printf("next 호출 %s \n", pointer);
			E e = get(pointer);
			pointer++;
			return e;
		}
	}
}
