package 자료구조.리스트;

public class CircularDoublyLinkedLIst implements IntegerListInterface {

    private BidirectionalNode head;
    private int numItems;

    public CircularDoublyLinkedLIst() {
        numItems = 0;
        head = new BidirectionalNode(null); // 더미 헤드
        head.next = head.prev = head;
    }

    @Override
    public void add(int index, Integer x) {
        if (index >= 0 && index <= numItems) {
            BidirectionalNode prevNode = getNode(index-1);
            BidirectionalNode newNode = new BidirectionalNode(prevNode, x, prevNode.next);
            newNode.next.prev = newNode;
            prevNode.next = newNode;
            numItems++;
        } else {
            /* 에러 처리 */
        }
    }

    @Override
    public void append(Integer x) {
        BidirectionalNode prevNode = head.prev; // 마지막 노드
        BidirectionalNode newNode = new BidirectionalNode(prevNode, x ,head);
        head.prev = newNode;
        prevNode.next = newNode;
        numItems++;
    }

    private BidirectionalNode getNode(int index) {
        if (index >= -1 && index < numItems) {
            BidirectionalNode curNode = head;
            // 앞에서부터 탐색
            if (index < numItems / 2) {
                for (int i = 0; i <= index; i++) {
                    curNode = curNode.next;
                }
            } else { // 뒤에서부터 탐색
                for (int i = numItems-1; i >=index; i--) {
                    curNode = curNode.prev;
                }
            }

            return curNode;
        } else {
            return null;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index >= 0 && index < numItems) {
            BidirectionalNode curNode = getNode(index);
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            numItems--;
            return curNode.item;
        } else return null;
    }

    @Override
    public boolean removeItem(Integer x) {
        BidirectionalNode curNode = head;
        for (int i = 0; i < numItems; i++) {
            curNode = curNode.next;
            if (curNode.item.compareTo(x) == 0) {
                curNode.prev.next = curNode.next;
                curNode.next.prev = curNode.prev;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < numItems) {
            return getNode(index).item;
        }
        return null;
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
        BidirectionalNode curNode = head;
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
        head = new BidirectionalNode(null);
        head.next = head.prev = head;
    }
}
