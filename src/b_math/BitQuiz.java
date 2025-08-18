package b_math;

public class BitQuiz {
    
    public static void main(String[] args) {
        int a = 15;
        int b = 30;
        
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        
        System.out.println("15 => " + a);
        System.out.println("30 => " + b);
        
        // a xor 0 은 언제나 0이다.
        // a xor 1 은 not a 이다.
    }
}
