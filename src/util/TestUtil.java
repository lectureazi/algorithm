package util;

import java.util.Random;

public class TestUtil {

    public static int[] createIntArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void measure(Measurable target){
        long start = System.currentTimeMillis();

        target.measure();

        long end = System.currentTimeMillis();
        System.out.printf( "소요시간 : %s \n", end - start);
    }
}
