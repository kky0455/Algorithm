import java.io.*;
// N번째 타일의 조합은 N-1과 N-2타일 조합으로 풀 수 있다.
public class B11727 {
    static int N;
    static int[] DP = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP[1] = 1;
        DP[2] = 3;
        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i-1] + 2 * DP[i-2]) % 10007;
        }
        System.out.println(DP[N]);
    }
}
