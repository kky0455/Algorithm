import java.io.*;
// 점화식 규칙에 따라 N번째는 -1, -2한 인덱스값의 합
public class B1904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[1000001];

        DP[1] = 1;
        DP[2] = 2;

        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 15746;
        }

        System.out.println(DP[N]);
    }
}
