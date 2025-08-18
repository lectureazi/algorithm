package f_divideandconcure.quiz;

import c_datastructure.stack._Stack;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    public static void main(String[] args) {
        System.out.println(powRecursive(2,10));
        System.out.println(powStack(2,10));
    }

    static int powRecursive(int a, int b) {
        if(b == 0) return 1;
        if(b == 1) return a;

        int halfPow = powRecursive(a, b/2);

        if(b % 2 == 0) {
            return halfPow * halfPow;
        }else{
            return halfPow * halfPow * a;
        }
    }

    // 거듭제곱 최적화를 stack을 활용해서 구현해주세요.
    static int powStack(int a, int b){
        _Stack<Integer> stack = new _Stack<>();

        if(b == 0) return 1;
        if(b == 1) return a;

        int result = 1;
        stack.push(b);

        while(b > 1){
            b /= 2;
            stack.push(b);
        }

        while(!stack.isEmpty()){
            int exponent = stack.pop();
            if(exponent % 2 == 0){
                result *= result;
            }else{
                result *= result * a;
            }
        }

        return result;
    }

    static void q2(){
        List<Meeting> meetings = createMeetings();

    }

    private static List<Meeting> createMeetings() {
        List<Meeting> meetings = new ArrayList<Meeting>();
        meetings.add(new Meeting("개발", 1, 10));
        meetings.add(new Meeting("기획", 5, 6));
        meetings.add(new Meeting("인사", 13, 15));
        meetings.add(new Meeting("총무", 14, 17));
        meetings.add(new Meeting("QA", 8, 14));
        meetings.add(new Meeting("CS", 3, 12));
        return meetings;
    }
}
