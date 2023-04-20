package 자료구조.힙;

public class Heap<E extends Comparable> implements PQInterface<E>{

    private E[] A;
    private int numItems;

    public Heap(int arraySize) {
        A = (E[]) new Comparable[arraySize];
        numItems = 0;
    }

    public Heap(E[] B, int numElements) {
        A = B; // 배열 레퍼런스 복사
        numItems = numElements;
        buildHeap();
    }

    // 배열 힙 생성하기
    private void buildHeap() {
        // 리프 노드가 아닌 첫 번째 노드부터 루트 노드까지 heapDown 수행
        for (int i = (numItems-2)/2; i >= 0; i--) {
            heapDown(i);
        }
    }

    // 힙에 원소 삽입하기
    @Override
    public void insert(E newItem) throws Exception {
        if (numItems < A.length) {
            A[numItems] = newItem;
            heapUp(numItems);
            numItems++;
        } else throw new PQException("HeapErr: Insert()-Overflow!");
    }

    private void heapUp(int index) {
        int parent = (index -1)/2;
        while (parent >= 0 && A[parent].compareTo(A[index]) < 0) {
            E tmp = A[parent];
            A[parent] = A[index];
            A[index] = tmp;
            index = parent;
            parent = (index-1)/2;
        }
    }

    // 힙에서 원소 삭제하기
    @Override
    public E deleteMax() throws Exception {
        if (!isEmpty()) {
            E max = A[0];
            A[0] = A[numItems-1];
            numItems--;
            heapDown(0);
            return max;
        } else throw new PQException("HeapErr: DeleteMax()-Underflow!");
    }

    private void heapDown(int index) {
        while (2*index + 1 < numItems) {
            int child = 2*index + 1; // 왼쪽 자식
            int rChild = 2*index + 2; // 오른쪽 자식
            if (rChild < numItems && A[rChild].compareTo(A[child]) > 0) { // 더 큰 자식의 래퍼런스
                child = rChild;
            }
            if (A[index].compareTo(A[child]) < 0) {
                E tmp = A[index];
                A[index] = A[child];
                A[child] = tmp;
                index = child;
            } else break;
        }
    }

    @Override
    public E max() throws Exception {
        if (!isEmpty()) return A[0];
        else throw new PQException("HeapErr: Max()-Empty!");
    }

    @Override
    public boolean isEmpty() {
        return numItems==0;
    }

    @Override
    public void clear() {
        A = (E[]) new Comparable[A.length];
        numItems = 0;
    }
}
