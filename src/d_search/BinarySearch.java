package d_search;

// 정렬된 자료구조를 대상으로만 사용할 수 있다.
public class BinarySearch {

    static int binarySearch(int[] arr, int target){
        int pl = 0; // 왼쪽인덱스
        int pr = arr.length-1;

        while(pl <= pr){
            int center =( pl + pr)/2; // 중간 인덱스
            if(arr[center] == target) return center;

            if(target < arr[center]) {
                pr = center - 1;
            }else{
                pl = center + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // target : 14
        int[] arr ={1, 3, 5, 9, 10, 11, 14, 29, 30, 31, 35, 44};
        System.out.println(binarySearch(arr, 29));
    }
}
