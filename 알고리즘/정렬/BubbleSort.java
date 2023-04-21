package 알고리즘.정렬;

/**
 * 버블 정렬
 */
public class BubbleSort {
    public static void sort(int arr[]) {
       // 모든 원소가 정렬될 때까지 n-1 번 수행
        for (int i = 0; i < arr.length - 1; i++) {
            // 이웃 노드와 교환하여 가장 큰 수를 맨 마지막으로 보냄
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    // 스왑
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }
}
