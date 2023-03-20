import java.io.*;
// 조건에 맞게 문자열을 바꾸는 문제
// 자바에서 문자열 제거, 뒤집기를 편하게 하기 위해 StringBuilder를 사용한다.
public class B12904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while (S.length() < T.length()){
            if (T.charAt(T.length()-1) == 'A') {
                T.deleteCharAt(T.length()-1);
            } else if (T.charAt(T.length()-1) == 'B') {
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }

        if (T.toString().equals(S.toString())) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
