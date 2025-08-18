package f_divideandconcure;

import util.Measurable;
import util.TestUtil;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = TestUtil.createIntArray(100000);

        TestUtil.measure(new Measurable() {
            @Override
            public void measure() {
                quickSort(arr, 0, arr.length - 1);
            }
        });

        //System.out.println(Arrays.toString(arr));
    }

    static int partition(int[] arr, int first, int last) {
        int pivotElement = arr[first];
        int p1 = first + 1;
        int p2 = last;

        while(p1 <= p2){
            while(p1 <= last && arr[p1] < pivotElement){
                p1++;
            }

            while(p2 >= last && arr[p2] > pivotElement){
                p2--;
            }

            if(p1 <= p2){
                TestUtil.swap(arr, p1++, p2--);
            }
        }

        TestUtil.swap(arr, first, p2); // pivot을 가운데 요소와 swap
        return p2; // return pivot point
    }

    static void quickSort(int[] arr, int first, int last) {
        if(first <= last){
            int pivot = partition(arr, first, last);
            quickSort(arr, first, pivot - 1);
            quickSort(arr, pivot + 1, last);
        }
    }
}
