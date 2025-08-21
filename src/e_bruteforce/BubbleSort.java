package e_bruteforce;

import util.Measurable;
import static util.SearchUtil.*;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = createRandomIntArray(100000);

        measure(new Measurable() {
            @Override
            public void measure() {
                bubbleSort(arr);
            }
        });
        
        measure(new Measurable() {
            @Override
            public void measure() {
                bubbleSort2(createRandomIntArray(100000));
            }
        });

        //System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    static void bubbleSort2(int[] arr){
        for (int i = 1; i <= arr.length; i++) {
            boolean notChanged = true;

            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    notChanged = false;
                }
            }

            if(notChanged) break;
        }
    }




}
