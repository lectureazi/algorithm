package c_datastructure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import c_datastructure.dto.School;

public class Run {

	public static void main(String[] args) {
		//testAdd();
		//testGet();
		//testSet();
		//testRemove();
		//testSchool();
		testIterable();
	}
	
	static void testAdd() {
		
		_LinkedList<Integer> list = new _LinkedList<Integer>();
		
		for (int i = 0; i < 30; i++) {
			list.add(i);
		}
		
		System.out.println(list);
	}
	
	static void testGet() {
		
		_LinkedList<Integer> list = new _LinkedList<Integer>();
		
		for (int i = 0; i < 30; i++) {
			list.add(i);
		}
		
		for (int i = 5; i < 8; i++) {
			System.out.println(list.get(i));
		}
	}
	
	static void testSet() {
		_LinkedList<Integer> list = new _LinkedList<Integer>();
		
		for (int i = 0; i < 30; i++) {
			list.add(i);
		}
		
		for (int i = 5; i < 8; i++) {
			list.set(i, 9999);
		}
		
		System.out.println(list);
	}
	
	static void testRemove() {
		_LinkedList<Integer> list = new _LinkedList<Integer>();
		
		for (int i = 0; i < 30; i++) {
			list.add(i);
		}
		
		for (int i = 5; i < 8; i++) {
			list.remove(i);
		}
		
		System.out.println(list);
	}
	
	static void testIterable() {
		_ArrayList<Integer> list = new _ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	static void testSchool() {
		
		School seoulUniv = new School("서울대", "관악구", 4);
		School yunsae = new School("연세대", "신촌", 4);
		School minsa = new School("민사고", "대전", 3);
		School multicampus = new School("멀티캠퍼스", "삼성", 2);
		School semyeong = new School("세명초", "머리", 1);
		
		ArrayList<School> list = new ArrayList<School>();
		list.add(seoulUniv);
		list.add(yunsae);
		list.add(minsa);
		list.add(multicampus);
		list.add(semyeong);
		
		// School level을 기준으로 오름차순 정렬
		// * level 기준으로 오름차순 정렬하되, 만약 level이 같다면 대학교 이름으로 내림차순정렬
		Collections.sort(list);
		
		// Comparator 인터페이스는 Functional Interface 이기 때문에 람다표현식으로 사용 가능
		Collections.sort(list, new Comparator<School>() {
			@Override
			public int compare(School o1, School o2) {
				return o1.getAddress().compareTo(o2.getAddress());
			}
		});
		
		System.out.println(list);
	}	
}
