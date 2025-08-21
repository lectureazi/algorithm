package f_divideandconcure;

import util.Measurable;

import java.util.Arrays;

import static util.SearchUtil.*;

// top-down (하향식)
// 커다란 문제를 작은 부분으로 분할하며 해결
// Divide (문제를 분할) Conquer(정복) Combine (합침)
// 시작점 : 전체 배열
// 진행 방향 : 전체 배열 -> 분할 -> 정복(분할된 배열을 정렬) -> 병합
public class MergeSort {

    public static void main(String[] args) {

        measure(new Measurable() {
            @Override
            public void measure() {
                mergeSort(createRandomIntArray(1000000));
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
            // 후위증감연산자 : 대입연산 이후 실행
            res[idx++] = a[p1++];
        }

        while(p2 < b.length){
            res[idx++] = b[p2++];
        }

        return res;
    }
}
