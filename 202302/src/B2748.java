import java.io.*;

public class B2748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] DP = new long[91];
        DP[1] = 1;

        int N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        System.out.println(DP[N]);
    }
}
