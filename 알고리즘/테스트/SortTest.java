import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import 알고리즘.정렬.*;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {
    int arr[];

    @BeforeEach
    void init() {
        arr = new int[] {1,5,3,2,4,6,9,7,10,8};
    }

    @Test
    @DisplayName("선택 정렬 테스트")
    void selectionSort() {
        SelectionSort.sort(arr);
        test();
    }

    @Test
    @DisplayName("버블 정렬 테스트")
    void bubbleSort() {
        BubbleSort.sort(arr);
        test();
    }

    @Test
    @DisplayName("삽입 정렬 테스트")
    void insertionSort() {
        InsertionSort.sort(arr);
        test();
    }

    @Test
    @DisplayName("병합 정렬 테스트")
    void mergeSort() {
        MergeSort.sort(arr, 0, arr.length-1);
        test();
    }

    @Test
    @DisplayName("퀵 정렬 테스트")
    void quickSort() {
        QuickSort.sort(arr, 0, arr.length-1);
        test();
    }

    private void test() {
        for (int i = 1; i <=10; i++) {
            assertThat(arr[i-1]).isEqualTo(i);
        }
    }
}