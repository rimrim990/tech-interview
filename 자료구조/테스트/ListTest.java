import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import 자료구조.리스트.*;

import static org.assertj.core.api.Assertions.assertThat;

class ListTest {

    @Test
    @DisplayName("IntegerArrayList 테스트")
    void IntegerArrayList() {
        // given
        IntegerListInterface list = new IntegerArrayList();

        // when
        for (int i = 0; i < 5; i++) {
            list.append(i);
        }

        // then - 검증
        assertThat(list.len()).isEqualTo(5);

        for (int i = 0; i < 5; i++) {
            assertThat(list.indexOf(i)).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("IntegerLinkedList 테스트")
    void IntegerLinkedList() {
        // given
        IntegerListInterface list = new IntegerLinkedList();

        // when
        for (int i = 0; i < 5; i++) {
            list.append(i);
        }

        // then
        assertThat(list.len()).isEqualTo(5);

        for (int i = 0; i < 5; i++) {
            assertThat(list.indexOf(i)).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("CircularLinkedList 테스트")
    void CircularLinkedList() {
        IntegerListInterface clist = new CircularLinkedList();

        for (int i = 0; i < 5; i++) {
            clist.add(0, i);
        }
        clist.removeItem(3);

        assertThat(clist.len()).isEqualTo(4);
        assertThat(clist.indexOf(3)).isEqualTo(-1);
        assertThat(clist.indexOf(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("CircularDoublyLinkedList 테스트")
    void CircularDoublyLinkedList() {
        IntegerListInterface cdlist = new CircularDoublyLinkedLIst();

        for (int i = 0; i < 5; i++) {
            cdlist.add(0, i);
        }
        cdlist.removeItem(2);

        assertThat(cdlist.len()).isEqualTo(4);
        assertThat(cdlist.indexOf(2)).isEqualTo(-1);
        assertThat(cdlist.indexOf(1)).isEqualTo(2);
    }
}