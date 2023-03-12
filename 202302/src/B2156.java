import java.io.*;

public class B2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] w = new int [N];
        int[] DP = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        DP[0] = w[0];

        for (int i = 1; i < N; i++) {
            if (i == 1) {
                DP[1] = w[0] + w[1];
                continue;
            }
            if (i == 2) {
                DP[2] = Math.max(DP[1], Math.max(w[0]+w[2], w[1]+w[2]));
                continue;
            }
            DP[i] = Math.max(DP[i-1], Math.max(DP[i-2] + w[i], DP[i-3] + w[i-1] + w[i]));
        }

        System.out.println(DP[N-1]);
    }
}
