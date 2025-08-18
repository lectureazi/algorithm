package c_datastructure.map.quiz;

import c_datastructure.list._LinkedList;
import c_datastructure.map.Entry;
import c_datastructure.map._HashMap;

public class Quiz {

    public static void main(String[] args) {
        q1("multicampus");
    }

    public static void q1(String text){

        _LinkedList<Character> list = new _LinkedList<>();
        _HashMap<Character, Integer> map = new _HashMap<>();

        for (char ch : text.toCharArray()) {
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
                continue;
            }
            map.put(ch, 1);
        }
        
        // 최대 문자 등장 횟수 찾기
        int max = 1;

        for (Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }

        for (Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }

        System.out.println(list);
    }
}
