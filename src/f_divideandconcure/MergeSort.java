package f_divideandconcure;

import util.Measurable;

import java.util.Arrays;

import static util.TestUtil.*;

public class MergeSort {

    public static void main(String[] args) {

        measure(new Measurable() {
            @Override
            public void measure() {
                mergeSort(createIntArray(100000));
            }
        });

        // int[] arr = mergeSort(createIntArray(10));
        // System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if(n <= 1) return arr;

        int mid = n/2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, n));

        return merge(arr1, arr2);
    }

    // 정렬이 끝난 두 배열을 합쳐 정렬된 하나의 배열로 만들자.
    static int[] merge(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        int p1 = 0, p2 = 0, idx = 0;

        while(p1 < a.length && p2 < b.length){
            if(a[p1] < b[p2]){
                res[idx] = a[p1++];
            }else{
                res[idx] = b[p2++];
            }

            idx++;
        }

        while(p1 < a.length){
            res[idx++] = a[p1++];
        }

        while(p2 < b.length){
            res[idx++] = b[p2++];
        }

        return res;
    }
}
