package 알고리즘.정렬;

public class MergeSort {

    // 배열을 재귀적으로 나눠 정렬한다
    public static void sort(int[] arr, int start, int end) {
        if (start==end) return;
        int mid = (start+end) / 2;
        // 1. 절반으로 분할하여 정렬
        sort(arr, start, mid);
        sort(arr, mid+1, end);
        // 2. 정렬된 배열 병합
        merge(arr, start, mid, end);
    }

    // 정렬된 두 배열 a 와 b 를 하나의 배열로 합친다
    private static void merge(int[] arr, int start, int mid, int end) {
        int tmp[] = new int[end-start+1];
        // 투 포인터
        int left = start, right = mid+1, t = 0;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                tmp[t++] = arr[left++];
            } else {
                tmp[t++] = arr[right++];
            }
        }

        // 왼쪽 남은 배열
        while (left <= mid) {
            tmp[t++] = arr[left++];
        }

        // 오른쪽 남은 배열
        while (right <= end) {
            tmp[t++] = arr[right++];
        }

        // arr 로 복사
        for (int i = 0; i <tmp.length; i++) {
            arr[i+start] = tmp[i];
        }
    }
}
