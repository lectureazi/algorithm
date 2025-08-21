package f_divideandconcure;

import static util.SearchUtil.createRandomIntArray;
import static util.SearchUtil.measure;
import util.Measurable;

// bottom-up (상향식)
// 가장 간단하고 작은 부분 문제들을 먼저 해결한 후, 이 해답들을 결합하여 점차 더 큰 문제의 해답을 만들어나가는 방식
// 시작점 : 가장 작은 문제 (길이가 1인 배열)
// 진행 방향 : 부분 -> 전체
public class BottomUpMergeSort {
    
    public static void main(String[] args) {
        measure(new Measurable() {
            @Override
            public void measure() {
                mergeSort(createRandomIntArray(1000000));
            }
        });
    }
    
    static void mergeSort(int[] arr) {
        int n = arr.length;
        
        // size는 병합할 부분 배열의 길이를 나타내며, 1부터 시작하여 2배씩 증가
        for (int size = 1; size < n; size *= 2) {
            
            // left : 첫 번째 부분 배열의 시작 인덱스
            for (int left = 0; left < n - 1; left += 2 * size) {
                // 첫 번째 부분 배열의 끝 인덱스
                int mid = Math.min(left + size - 1, n - 1);
                // 두 번째 부분 배열의 끝 인덱스
                int right = Math.min(left + 2 * size - 1, n - 1);
                // 두 부분 배열을 병합
                merge(arr, left, mid, right);
            }
        }
    }
    
    // 정렬이 끝난 두 부분 배열을 합쳐 정렬된 하나의 배열로 만드는 메서드
    static void merge(int[] arr, int left, int mid, int right) {
        
        int lSize = mid - left + 1; // index 는  0부터 시작
        int rSize = right - mid;
        
        // 병합할 오른쪽 배열이 없음, 배열의 크기가 2의 제곱수가 아닌 경우 발생
        if(rSize == 0) return;
        
        int[] l = new int[lSize];
        int[] r = new int[rSize];
        
        // 두 부분 배열을 임시 배열에 복사
        for (int i = 0; i < lSize; i++) {
            l[i] = arr[left + i];
        }
        
        for (int j = 0; j < rSize; j++) {
            r[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = left;
        
        // 두 임시 배열을 병합
        while (i < lSize && j < rSize) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        
        // 남은 요소들을 원래 배열에 복사
        while (i < lSize) {
            arr[k++] = l[i++];
        }
        while (j < rSize) {
            arr[k++] = r[j++];
        }
    }
}
