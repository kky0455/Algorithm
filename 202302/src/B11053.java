import java.io.*;
import java.util.*;
// 현재 숫자와 이전 숫자를 비교하며 DP 채워가기
public class B11053 {
    static int N;
    static int[] DP;
    static int[] A;
    static int answer = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
        A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            DP[i] = 1;
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j] && DP[i] <= DP[j]) {
                    DP[i] = DP[j] + 1;
                }
            }
            answer = Math.max(answer, DP[i]);
        }
        System.out.println(answer);
    }
}
