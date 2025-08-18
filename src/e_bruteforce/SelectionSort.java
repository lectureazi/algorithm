package e_bruteforce;

import util.Measurable;
import static util.TestUtil.createIntArray;
import static util.TestUtil.*;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = createIntArray(100000);

        measure(new Measurable() {
            @Override
            public void measure() {
                selectionSort(arr);
            }
        });

        //System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = min(arr, i);
            swap(arr, i, min);
        }
    }

    static int min(int[] arr, int point){
        int min = point;

        for (int i = point + 1; i < arr.length; i++) {
            if(arr[min] > arr[i]){
                min = i;
            }
        }
        return min;
    }

}
