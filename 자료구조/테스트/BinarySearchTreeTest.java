import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import 자료구조.검색트리.BinarySearchTree;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    BinarySearchTree bst;

    @BeforeEach
    void init() {
        bst = new BinarySearchTree();
    }

    @Test
    @DisplayName("BST 삽입 테스트")
    void insert() {
        for (int i = 0; i < 5; i++) {
            bst.insert(i);
            assertThat(bst.getRoot().key).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("BST 삭제 테스트")
    void delete() {
        for (int i = 0; i < 5; i++) {
            bst.insert(i);
        }
        for (int i = 0; i < 4; i++) {
            bst.delete(i);
            assertThat(bst.getRoot().key).isEqualTo(i+1);
        }
    }

}
