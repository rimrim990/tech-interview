package 자료구조.리스트;

public class IntegerLinkedList implements IntegerListInterface{

    private Node head;
    private int numItems;

    public IntegerLinkedList() {
        numItems = 0;
        head = new Node(null, null); // 더미 헤드
    }

    // 연결 리스트에 원소 x 삽입하기
    @Override
    public void add(int index, Integer item) {
        if (index >= 0 && index <= numItems) {
            Node prevNode = getNode(index-1);
            Node newNode = new Node(item, prevNode.next);
            prevNode.next = newNode;
            numItems++;
        }
    }

    public Node getNode(int index) {
        Node curNode = head; // 더미 노드
        if (index >= -1 && index < numItems) {
            // -1 은 더미 노드
            curNode = head;
            for (int i = 0; i <= index; i++) {
                curNode = curNode.next;
            }
            return curNode;
        } else {
            return null;
        }
    }

    @Override
    public void append(Integer item) {
        Node preNode = head; // 더미 노드
        while (preNode.next != null) {
            preNode = preNode.next;
        }
        preNode.next = new Node(item, null);
        numItems++;
    }

    // 리스트의 원소 삭제하기
    @Override
    public Integer remove(int index) {
        if (index >= 0 && index < numItems) {
            Node prevNode = getNode(index-1);
            Node curNode = prevNode.next;
            prevNode.next = curNode.next;
            return curNode.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeItem(Integer x) {
        Node prevNode, curNode = head; // 더미 노드
        for (int i = 0; i < numItems; i++) {
            prevNode = curNode;
            curNode = curNode.next;
            if (curNode.item.compareTo(x) == 0) {
                prevNode.next = curNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    // 연결 리스트의 k 번째 원소 알려주기
    @Override
    public Integer get(int index) {
        if (index >= 0 && index < numItems) {
            return getNode(index).item;
        } else {
            return null;
        }
    }

    // 연결 리스트의 k 번째 원소를 x 로 대체하기
    @Override
    public void set(int index, Integer x) {
        if (index >= 0 && index < numItems) {
            getNode(index).item = x;
        } else {
            /* 에러 처리 */
        }
    }

    // 원소 x 가 연결 리스트의 몇 번째 원소인지 알려주기
    public static final int NOT_FOUND = -1;

    @Override
    public int indexOf(Integer x) {
        Node curNode = head; // 더미 노드
        for (int i = 0; i < numItems; i++) {
            curNode = curNode.next;
            if (curNode.item.compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND; // not found
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    // 리스트 새로 할당하기
    @Override
    public void clear() {
        numItems = 0;
        head = new Node(null, null);
    }
}
