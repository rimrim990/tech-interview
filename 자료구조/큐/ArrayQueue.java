package 자료구조.큐;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E queue[]; // 원형 큐
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null; // 임의의 에러 값

    public ArrayQueue() { // 생성자
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        tail = DEFAULT_CAPACITY-1;
        numItems = 0;
    }

    public ArrayQueue(int n) {
        queue = (E[]) new Object[n];
        front = 0; // 원형 큐의 맨 앞
        tail = n-1; // 원형 큐의 맨 뒤
        numItems = 0;
    }

    // 큐에 원소 삽입하기
    @Override
    public void enqueue(E newItem) {
        if (isFull()) System.out.println("Queue Full!");
        else {
            tail = (tail+1) % queue.length; // 원형 큐
            queue[tail] = newItem;
            ++numItems;
        }
    }

    // 큐가 꽉 찼는지 확인하기
    public boolean isFull() {
        return (numItems == queue.length);
    }

    // 큐에서 원소 삭제하기
    @Override
    public E dequeue() {
        if (isEmpty()) return ERROR;
        else {
            E queueFront = queue[front];
            front = (front+1) % queue.length;
            --numItems;
            return queueFront;
        }
    }

    // 큐의 맨 앞 원소 알려주기
    @Override
    public E front() {
        if (isEmpty()) return ERROR;
        else return queue[front];
    }

    // 큐가 비었는지 확인하기
    @Override
    public boolean isEmpty() {
        return (numItems == 0);
    }

    // 큐 비우기
    @Override
    public void dequeueAll() {
        queue = (E[]) new Object[queue.length];
        front = 0;
        tail = queue.length-1;
        numItems = 0;
    }
}
