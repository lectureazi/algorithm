package c_datastructure.stack.quiz;

import c_datastructure.map._HashMap;
import c_datastructure.stack._Stack;

public class Quiz {
    public static void main(String[] args) {
        System.out.println(q1("{multicampus}(int a, b, c, d)[a = 100, b = 300]"));
        System.out.println(q1("{()[a,j,k,l,a,s,d,j,l,k,a,j]()}"));
        System.out.println(q1("{([a,j,k,l}])}"));
    }

    public static boolean q1(String text){
        _Stack<Character> stack = new _Stack<>();
        _HashMap<Character, Character> map = new _HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for (char ch : text.toCharArray()) {
            if(map.containsKey(ch)){
                stack.push(ch);
                continue;
            }

            if(!"}])".contains(String.valueOf(ch))) continue;
            if(stack.isEmpty()) return false;

            char k = stack.pop();

            if(ch != map.get(k)){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
