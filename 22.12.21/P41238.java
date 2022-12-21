import java.util.Stack;

public class P41238 {

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(s)) {
                answer++;
            }
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        return answer;
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    char o = stack.pop();
                    char e = s.charAt(i);
                    if (o == '(' && e == ')') continue;
                    else if (o == '{' && e == '}') continue;
                    else if (o == '[' && e == ']') continue;
                    else return false;
                } else return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}