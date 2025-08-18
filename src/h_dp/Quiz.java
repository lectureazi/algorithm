package h_dp;

public class Quiz {

    public static void main(String[] args) {
        calSubArraySum(new int[]{10, -4, 3, 1, 5, 6, -35, 12, 21, -1});
    }

    static void calSubArraySum(int[] arr){
        int currentSum = 0;
        int maxSum = 0;

        for (int n : arr) {
            currentSum = Math.max(currentSum + n, n);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
