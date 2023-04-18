package 자료구조.리스트;

/***
 * 배열로 리스트 구현
 */
public class IntegerArrayList implements IntegerListInterface {

    private Integer[] item;
    private int numItems; // item 배열의 크기 != 리스트 원소의 개수
    private static final int DEFAULT_CAPACITY = 64; // 기본 크기

    // 생성자 1 - 기본 크기로 생성
    public IntegerArrayList() {
        item = new Integer[DEFAULT_CAPACITY];
        numItems = 0;
    }

    // 생성자 2 - 사용자 지정 크기로 생성
    public IntegerArrayList(int n) {
        item = new Integer[n];
        numItems = 0;
    }

    // 배열 리스트의 k 번째 자리에 원소 x 삽입하기
    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            /* 에러 처리 */
        } else {
            for (int i = numItems-1; i >=index; i--) {
                item[i+1] = item[i]; // 우시프트
            }
            item[index] = x;
            numItems++;
        }
    }

    // 배열 리스트의 맨 뒤에 원소 추가하기
    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            /* 에러 처리 */
        } else {
            item[numItems++] = x;
        }
    }

    // 배열 리스트의 k 번째 원소 삭제하기
    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems-1) {
            return null;
        } else {
            Integer tmp = item[index];
            for (int i = index; i <= numItems-2; i++) {
                item[i] = item[i+1]; // 좌시프트
            }
            numItems--;
            return tmp;
        }
    }

    //배열 리스트에서 원소 x 삭제하기
    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0) {
            k++;
        }
        if (k == numItems) {
            return false;
        } else {
            for (int i = k; i < numItems-2; i++) {
                item[i] = item[i+1]; // 좌시프트
            }
            numItems--;
            return true;
        }
    }

    // 배열 리스트의 i 번째 원소 알려주기
    @Override
    public Integer get(int index) {
        if (index < 0 || index >= numItems) {
            return null;
        } else {
            return item[index];
        }
    }

    // 배열 리스트의 i 번째 원소를 x 로 대체
    @Override
    public void set(int index, Integer x) {
        if (index < 0 || index >= numItems) {
            /* 에러 처리 */
        } else {
            item[index] = x;
        }
    }

    // 원소 x 가 배열 리스트의 몇 번째 원소인지 알려주기
    private static final int NOT_FOUND = -1;
    @Override
    public int indexOf(Integer x) {
        for (int i = 0; i < numItems; i++) {
            if (((Comparable)item[i]).compareTo(x) == 0) {
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

    // 새로운 배열 리스트 할당
    @Override
    public void clear() {
        item = new Integer[item.length];
        numItems = 0;
    }
}