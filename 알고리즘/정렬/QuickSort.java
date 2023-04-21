package 알고리즘.정렬;

/**
 * 퀵 정렬
 */
public class QuickSort {
    public static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        // 피벗을 기준으로 작은 그룹과 큰 그룹으로 분할
        int pivot = partition(arr, start, end);
        // 재귀적으로 정렬 수행
        sort(arr, start, pivot-1);
        sort(arr, pivot+1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start+1, right = end;
        // 엇갈리기 전까지 교환
        while (left < right) {
            while (left <= end && arr[left] < pivot) {
                left++;
            }
            while (right > start && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }

        // 원소가 2개일 경우 예외처리
        if (pivot > arr[right]) {
            int tmp = arr[right];
            arr[right] = arr[start];
            arr[start] = tmp;
            return right;
        }
        return start;
    }
}
