import java.util.*;
import java.io.*;
// 인접한 색끼리 겹치지 않아야한다.
// 첫 최솟값을 찾고, 다음부터 그 값을 제외한 최솟값을 찾으며 DP를 채워가자
public class B1149 {
    static int N;
    static int[][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + R;
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + G;
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + B;
        }
        System.out.println(Math.min(DP[N][0], Math.min(DP[N][1], DP[N][2])));
    }
}
