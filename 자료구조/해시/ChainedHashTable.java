package 자료구조.해시;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import 자료구조.검색트리.IndexInterface;
import 자료구조.리스트.IntegerLinkedList;
import 자료구조.리스트.Node;

/**
 * 충돌 해결 방식으로 체이닝을 사용한 해시 테이블
 */
public class ChainedHashTable implements IndexInterface<Node> {
    private IntegerLinkedList[] table;
    int numItems;

    public ChainedHashTable(int n) {
        table = new IntegerLinkedList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new IntegerLinkedList();
        }
        numItems = 0;
    }

    // 해시 함수 - 키 값을 해시 테이블의 인덱스로 변환
    private int hash(Integer x) {
        return x % table.length;
    }

    @Override
    public Node search(Comparable x) {
        Integer val = (Integer) x;
        int slot = hash(val);
        if (table[slot].isEmpty()) return null;
        else {
            int i = table[slot].indexOf(val);
            if (i == IntegerLinkedList.NOT_FOUND) return null;
            return table[slot].getNode(i);
        }
    }

    @Override
    public void insert(Comparable x) {
        Integer val = (Integer) x;
        int slot = hash(val);
        table[slot].add(0, val);
        numItems++;
    }

    @Override
    public void delete(Comparable x) {
        if (isEmpty()) { /* 예외처리 */ ; }
        else {
            Integer val = (Integer)x;
            int slot = hash(val);
            table[slot].removeItem(val);
            numItems--;
        }
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new IntegerLinkedList();
        }
        numItems = 0;
    }
}
