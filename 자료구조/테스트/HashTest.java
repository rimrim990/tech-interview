import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import 자료구조.해시.ArrayHashTable;
import 자료구조.해시.ChainedHashTable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HashTest {

    @Test
    @DisplayName("체이닝 해시 테이블 삽입 테스트")
    public void chainingInsert() {
        ChainedHashTable hash = new ChainedHashTable(200);

        hash.insert(200);
        hash.insert(400);
        hash.insert(600);

        assertThat(hash.search(200).item).isEqualTo(200);
        assertThat(hash.search(400).item).isEqualTo(400);
        assertThat(hash.search(600).item).isEqualTo(600);
    }

    @Test
    @DisplayName("체이닝 해시 삭제 테스트")
    public void chainingDelete() {
        ChainedHashTable hash = new ChainedHashTable(200);

        hash.insert(300);
        hash.delete(300);

        assertThat(hash.search(300)).isEqualTo(null);
    }

    @Test
    @DisplayName("개방 주소 해시 삽입 테스트")
    public void openInsert() {
        ArrayHashTable hash = new ArrayHashTable(200);

        hash.insert(200);
        hash.insert(400); // 충돌
        hash.insert(600); // 충돌

        assertThat(hash.search(200)).isEqualTo(0);
        assertThat(hash.search(400)).isEqualTo(1);
        assertThat(hash.search(600)).isEqualTo(2);
    }

    @Test
    @DisplayName("개방 주소 해시 삭제 테스트")
    public void openDelete() {
        ArrayHashTable hash = new ArrayHashTable(200);

        hash.insert(200);
        hash.insert(400); // 충돌
        hash.insert(600); // 충돌
        hash.delete(400);

        assertThat(hash.search(400)).isEqualTo(-1);
    }
}
