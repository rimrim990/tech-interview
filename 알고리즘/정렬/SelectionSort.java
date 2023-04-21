package 알고리즘.정렬;

/**
 * 선택 정렬
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        // 모든 원소가 정렬될 때까지 n-1 번 수행
        for (int i = 0; i < arr.length-1; i++) {
            // 가장 큰 원소 선택
            int index = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[index] < arr[j]) {
                    index = j;
                }
            }
            // 가장 큰 원소와 마지막 원소 스왑
            int tmp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[index];
            arr[index] = tmp;
        }
    }
}
