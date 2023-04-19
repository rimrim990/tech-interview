package 자료구조.스택;

import 자료구조.리스트.Node;

public class LinkedStack implements StackInterface<Integer> {

    private Node topNode;
    private final Integer Error = null;

    public LinkedStack() {
        topNode = null;
    }

    // 스택에 원소 x 삽입하기
    @Override
    public void push(Integer newItem) {
        Node newNode = new Node(newItem, topNode);
        topNode = newNode;
    }

    @Override
    public Integer top() {
        if (isEmpty()) {
            return Error;
        } else {
            return topNode.item;
        }
    }

    @Override
    public Integer pop() {
        if (isEmpty()) return Error;
        else {
            Integer res = topNode.item;
            topNode = topNode.next;
            return res;
        }
    }

    @Override
    public boolean isEmpty() {
        return (topNode == null);
    }

    @Override
    public void popAll() {
        topNode = null;
    }
}
