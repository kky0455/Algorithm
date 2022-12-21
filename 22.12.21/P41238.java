import java.util.Arrays;
import java.util.Stack;

public class P41238 {

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                s = s.substring(i, s.length()) + s.substring(0, i);
            }
            if (check(s)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean check(String s) {
        char[] arr = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            char v = Arrays.asList(arr).get(i);
            if ();
        }
        return true;
    }
}