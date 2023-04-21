package 알고리즘.정렬;

public class InsertionSort {

    public static void sort(int[] arr) {
        // 모든 원소가 정렬될 땨까지 n-1번 수행
        for (int i = 1; i < arr.length; i++) {
            // 정렬된 원소에 삽입하기
            int pos;
            int val = arr[i];
            for (pos=i; pos >= 1; pos--) {
                if (val < arr[pos-1]) {
                    // 우 쉬프트
                    arr[pos] = arr[pos-1];
                } else break;
            }
            arr[pos] = val;
        }
    }
}
