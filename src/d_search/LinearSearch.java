package d_search;

public class LinearSearch {

    // 선형 탐색
    static int seqSearch(int[] arr, int target) {
        int i = 0;
        while(true){
            if(i == arr.length) return -1;
            if(arr[i] == target) return i;
            i++;
        }
    }

    // 보초법
    static int seqSearchSentinel(int[] arr, int target) {
        int lastIdx = arr.length - 1;
        if(arr[lastIdx] == target) return lastIdx;

        arr[lastIdx] = target; // 보초
        int i = 0;

        while(true){
            if(target == arr[i]){
                return i < lastIdx ? i : -1;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int index = seqSearch(new int[]{1,6,12,4,76,23, 41}, 4);
        System.out.println(index);
    }

}
