package 자료구조.스택;

// 제네릭
public interface StackInterface<E> {
    public void push (E newItem);
    public E top();
    public E pop();
    public boolean isEmpty();
    public void popAll();
}
