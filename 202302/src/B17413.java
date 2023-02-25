import java.util.*;
import java.io.*;
// 공백을 기준으로 단어를 나누기
// 괄호를 기준으로 열린 괄호를 만났을 때를 기준으로 판단하여 구현하자.
public class B17413 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '<') {
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
            } else if (s.charAt(i) == '>') {
                flag = false;
                sb.append(s.charAt(i));
                continue;
            }

            if (flag){
                sb.append(s.charAt(i));
            }
            else {
                if (s.charAt(i) == ' '){
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (i == s.length()-1){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}
