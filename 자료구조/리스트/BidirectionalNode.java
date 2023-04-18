package 자료구조.리스트;

public class BidirectionalNode {
    public BidirectionalNode prev;
    public Integer item;
    public BidirectionalNode next;

    public BidirectionalNode(Integer newItem) {
        item = newItem;
        prev = next = null;
    }

    public BidirectionalNode(BidirectionalNode prevNode, Integer newItem, BidirectionalNode nextNode) {
        prev = prevNode;
        item = newItem;
        next = nextNode;
    }
}
