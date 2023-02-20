import java.io.*;
// 피카츄~~
// 정규표현식을 활용한 문제, 단순히 replace를 사용하지 않고 replaceAll을 사용하자
// 그냥 replace를 쓰면 문자가 소거되며 새로운 피카츄가 생길 수 있다.
public class B14405 {
    static String str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        str = str.replaceAll("pi|ka|chu","");
        if (str.equals("")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
