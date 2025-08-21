package f_divideandconcure;

import java.util.Arrays;
import util.Measurable;
import util.SearchUtil;

public class QuickSortRecursive {

    public static void main(String[] args) {
        int[] arr = SearchUtil.createRandomIntArray(100000000);
        //int[] arr = {26, 26, 5, 37, 1, 61, 11, 59, 15, 48, 19, 26};
        //int[] arr = {5, 20, 10, 15, 20};
        SearchUtil.measure(new Measurable() {
            @Override
            public void measure() {
                quickSort(arr, 0, arr.length - 1);
            }
        });

        //System.out.println(Arrays.toString(arr));
    }
    
    static int partition(int[] arr, int first, int last) {
        int pivotElement = arr[first];
        int p1 = first;
        int p2 = last;
        
        while(true){
            while(p1 < last && arr[p1] <= pivotElement){
                p1++;
            }
            
            while(p2 > first && arr[p2] >= pivotElement){
                p2--;
            }
            
            if(p1 >= p2) break;
            SearchUtil.swap(arr, p1++, p2--);
        }
        
        SearchUtil.swap(arr, first, p2); // pivot을 가운데 요소와 swap
        return p2; // return pivot point
    }

    static void quickSort(int[] arr, int first, int last) {
        if(first >= last) return;
        int pivot = partition(arr, first, last);
        quickSort(arr, first, pivot - 1);
        quickSort(arr, pivot + 1, last);
    }
}
