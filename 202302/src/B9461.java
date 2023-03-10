import java.io.*;

public class B9461 {
    static long[] DP = new long[101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        DP[1] = DP[2] = DP[3] = 1;
        DP[4] = DP[5] = 2;
        for (int i = 6; i <= 100; i++) {
            DP[i] = DP[i-1] + DP[i-5];
        }
        for (int tc = 1; tc <= T; tc++) {
            System.out.println(DP[Integer.parseInt(br.readLine())]);
        }
    }
}
