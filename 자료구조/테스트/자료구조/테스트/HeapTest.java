package 자료구조.테스트;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import 자료구조.힙.Heap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    @DisplayName("힙 원소 추가 테스트")
    public void insert() throws Exception {
        Heap<Integer> heap = new Heap<>(10);

        for (int i = 0; i < 5; i++) {
            heap.insert(i);
            assertThat(heap.max()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("힙 원소 제거 테스트")
    public void deleteMax() throws Exception {
        Heap<Integer> heap = new Heap<>(10);
        for (int i = 0; i < 5; i++) {
            heap.insert(i);
        }

        for (int i = 0; i < 5; i++) {
            assertThat(heap.deleteMax()).isEqualTo(4-i);
        }
    }

    @Test
    @DisplayName("빌드 힙 테스트")
    public void buildHeap() throws Exception {
        // given
        Integer arr[] = {1,2,3,4,5};

        // when
        Heap<Integer> heap = new Heap<>(arr, arr.length);

        // then
        for (int i = 0; i < 5; i++) {
            assertThat(heap.deleteMax()).isEqualTo(5-i);
        }
    }

}