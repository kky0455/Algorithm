import java.util.*;
import java.io.*;

// M개에서 N개를 선택하는 조합문제
// 조합의 성질을 이용해 문제를 풀어야합니다.

public class B1010 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] DP = new int[30][30];

        for (int i = 1; i <= 29; i++) {
            DP[i][1] = i;
        }

        for (int i = 2; i <= 29; i++) {
            for (int j = 2; j <= 29; j++) {
                DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(DP[M][N]);
        }
    }
}
