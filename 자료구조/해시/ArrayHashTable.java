package 자료구조.해시;

import 자료구조.검색트리.IndexInterface;

/**
 * 충돌 해결 방식으로 개방 주소 방법을 사용한 해시 테이블
 */
public class ArrayHashTable implements IndexInterface<Integer> {
    private Integer table[];
    int numItems;
    // 중간에 원소가 삭제되면 탐색이 중단될 수 있으므로 DELETED 플래그 표시
    static final Integer DELETED = -12345, NOT_FOUND = -1;

    public ArrayHashTable(int n) {
        table = new Integer[n];
        numItems = 0;
        for (int i = 0; i < n; i++) {
            table[i] = null;
        }
    }

    private int hash(int i, Integer x) {
        return (x+i) % table.length;
    }

    @Override
    public Integer search(Comparable x) {
        int slot;
        Integer val = (Integer) x;
        for (int i = 0; i < table.length; i++) {
            slot = hash(i, val);
            if (table[slot] == null) return NOT_FOUND; // 검색 실패
            if (table[slot].compareTo(val) == 0) {
                return slot;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public void insert(Comparable x) {
        int slot;
        Integer val = (Integer) x;
        if (numItems == table.length) { /* 에러 처리*/ }
        else {
            for (int i = 0; i < table.length; i++) { // 선형 탐색
                slot = hash(i, val);
                if (table[slot] == null || table[slot] == DELETED) {
                    table[slot] = val;
                    numItems++;
                    break;
                }
            }
        }
    }

    @Override
    public void delete(Comparable x) {
        int slot;
        Integer val = (Integer) x;
        for (int i = 0; i < table.length; i++) {
            slot = hash(i, val);
            if (table[slot] == null) break;
            if (table[slot].compareTo(val) == 0) {
                table[slot] = DELETED;
                numItems--;
                break;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
