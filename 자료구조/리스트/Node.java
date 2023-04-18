package 자료구조.리스트;

public class Node {
    public Integer item;
    public Node next;

    public Node(Integer newItem) {
        item = newItem;
        next = null;
    }

    public Node(Integer newItem, Node nextNode) {
        item = newItem;
        next = nextNode;
    }
}