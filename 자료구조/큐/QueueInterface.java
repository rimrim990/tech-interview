package 자료구조.큐;

public interface QueueInterface<E> {
    public void enqueue(E x);
    public E dequeue();
    public E front();
    public boolean isEmpty();
    public void dequeueAll();
}
