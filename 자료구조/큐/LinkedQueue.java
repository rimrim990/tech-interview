package 자료구조.큐;

import 자료구조.리스트.Node;

public class LinkedQueue implements QueueInterface<Integer> {

    private Node tail;
    private Node head;

    private final Integer Error = null;

    public LinkedQueue() {
        tail = null;
    }

    // 큐에 원소 삽입하기
    @Override
    public void enqueue(Integer x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) return Error;
        else {
            Node curNode = head;
            head = head.next;
            if (curNode == tail) {
                tail = null;
            }
            return curNode.item;
        }
    }

    @Override
    public Integer front() {
        if (isEmpty()) return Error;
        else return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return (tail == null);
    }

    @Override
    public void dequeueAll() {
        tail = null;
    }
}
