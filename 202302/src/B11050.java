import java.io.*;
import java.util.*;
// 이항계수 기본 개념 공부
// 조합의 원리를 활용해 N, K좌표의 이항계수값 구하기
public class B11050 {
    static int[][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        DP = new int[N+1][K+1];

        System.out.println(BC(N, K));
    }

    static int BC(int n, int k) {
        if (DP[n][k] > 0) {
            return DP[n][k];
        }

        if (k == 0 || n == k) {
            return DP[n][k] = 1;
        }

        return DP[n][k] = BC(n-1, k-1) + BC(n-1, k);
    }
}
