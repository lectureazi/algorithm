package d_search;

// 정렬된 자료구조를 대상으로만 사용할 수 있다.
public class BinarySearch {

    static int binarySearch(int[] arr, int target){
        int lp = 0; // 왼쪽인덱스
        int rp = arr.length-1;

        while(lp <= rp){
            int center =( lp + rp ) / 2; // 중간 인덱스
            if(arr[center] == target) return center;

            if(target < arr[center]) {
                rp = center - 1;
            }else{
                lp = center + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // target : 30
        int[] arr ={1, 3, 5, 9, 10, 11, 14, 29, 30, 31, 35, 44};
        System.out.println(binarySearch(arr, 30));
    }
}
