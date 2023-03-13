import java.io.*;
// 2차원 배열을 사용
// 앞은 자리수, 뒤는 해당하는 숫자를 담당
// 해당 위치의 계단 수는 그 전 자리수에서 1차이나는 숫자들의 합
public class B10844 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long answer = 0;
        long DP[][] = new long[N+1][10];

        for (int i = 1; i < 10; i++) {
            DP[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    DP[i][0] = DP[i-1][1] % 1000000000;
                } else if (j == 9) {
                    DP[i][9] = DP[i-1][8] % 1000000000;
                } else {
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % 1000000000;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            answer += DP[N][i];
        }

        System.out.println(answer%1000000000);
    }
}
