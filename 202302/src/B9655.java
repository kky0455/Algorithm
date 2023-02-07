import java.util.*;
import java.io.*;

// 돌을 1개 혹은 3개만 가져가 마지막 돌을 가져가는 사람이 이기는 게임
// 경우의 수를 따져보면 자신이 다음에 가져갈 수 있는 돌은 n-2, n-4, n-6이 있다
// 결국 홀수, 짝수가 나눠져있는 게임
public class B9655 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
