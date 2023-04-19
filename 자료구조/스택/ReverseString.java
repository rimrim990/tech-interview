package 자료구조.스택;

/**
 * 입력으로 들어온 문자열 뒤집기
 */
public class ReverseString {

    public static void main(String[] args) {
        String input = "Test Seq 12345";
        String t = reverse(input);
        System.out.println("Input String = " + input);
        System.out.println("Reversed String = " + t);
    }

    private static String reverse(String s) {
        ArrayStack<Character> st = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        String output = "";
        while (!st.isEmpty()) {
            output = output + st.pop();
        }
        return output;
    }
}
