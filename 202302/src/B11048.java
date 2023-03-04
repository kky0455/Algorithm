import java.io.*;
import java.util.*;

public class B11048 {
    static int N, M;
    static int[][] arr;
    static int[][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        DP = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                DP[i][j] = Math.max(arr[i][j] + DP[i-1][j], arr[i][j] + DP[i][j-1]);
            }
        }
        System.out.println(DP[N][M]);
    }
}
