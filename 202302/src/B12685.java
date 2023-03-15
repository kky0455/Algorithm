import java.io.*;
import java.util.StringTokenizer;

public class B12685 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - arr[i][0] >= 0) {
                    DP[i][j] = Math.max(DP[i-1][j], arr[i][1]+ DP[i-1][j-arr[i][0]]);
                }
                else {
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        System.out.println(DP[N][K]);
    }
}
