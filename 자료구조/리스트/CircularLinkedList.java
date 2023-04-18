package 자료구조.리스트;

public class CircularLinkedList implements IntegerListInterface {
    private Node tail;
    private int numItems;

    public CircularLinkedList() { // 생성자
        numItems = 0;
        tail = new Node(-1);
        tail.next = tail;
    }

    @Override
    public void add(int index, Integer x) {
        if (index >= 0 && index <= numItems) {
            Node prevNode = getNode(index-1);
            Node newNode = new Node(x, prevNode.next);
            prevNode.next = newNode;
            if (index == numItems) {
                tail = newNode;
            }
            numItems++;
        }

    }

    private Node getNode(int index) {
        if (index >= -1 && index < numItems) {
            Node curNode = tail.next; // 더미 헤드
            for (int i = 0; i <= index; i++) {
                curNode = curNode.next;
            }
            return curNode;
        } else {
            return null;
        }
    }

    // 맨 마지막에 원소 삽입
    @Override
    public void append(Integer x) {
        Node prevNode = tail; // 마지막 노드
        Node newNode = new Node(x, tail.next); // tail.next = 첫 번째 노드
        prevNode.next = newNode;
        tail = newNode; // newNode 가 마지막 노드가 됨
        numItems++;
    }

    @Override
    public Integer remove(int index) {
        if (index >= 0 && index < numItems) {
            Node prevNode = getNode(index-1);
            Node curNode = prevNode.next;
            prevNode.next = curNode.next;
            if (index == numItems-1) {
                tail = prevNode;
            }
            numItems--;
            return curNode.item;
        } else return null;
    }

    @Override
    public boolean removeItem(Integer x) {
        Node curNode = tail.next; // 더미 헤드
        Node prevNode;
        for (int i = 0; i < numItems; i++) {
            prevNode = curNode;
            curNode = curNode.next;
            if (curNode.item.compareTo(x) == 0) {
                prevNode.next = curNode.next;
                if (i == numItems-1) {
                    tail = prevNode;
                }
                numItems--;
                return true;
            }
        }
        return false; // not found
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < numItems) {
            return getNode(index).item;
        } else {
            return null;
        }
    }

    @Override
    public void set(int index, Integer x) {
        if (index >= 0 && index < numItems) {
            getNode(index).item = x;
        } else {
            /* 에러 처리 */
        }
    }

    private static final int NOT_FOUND = -1;
    @Override
    public int indexOf(Integer x) {
        Node curNode = tail.next; // 더미 헤드
        for (int i = 0; i < numItems; i++) {
            curNode = curNode.next;
            if (curNode.item.compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        tail = new Node(-1); // 더미 헤드
        tail.next = tail;
    }
}
