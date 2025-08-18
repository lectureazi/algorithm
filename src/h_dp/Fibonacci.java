package h_dp;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    static int fibonacci(int n) {
        int[] cached = new int[n];
        cached[0] = 1;
        cached[1] = 1;

        for (int i = 2; i < n; i++) {
            cached[i] = cached[i-1] + cached[i-2];
        }

        return cached[n-1];
    }
}
