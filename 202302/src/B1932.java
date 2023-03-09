import java.util.*;
import java.io.*;
// 계단을 내려가면서 가장 최대가 되는 수를 구하는 문제
// 밑에서 올라가면 다시 탐색하는 과정을 줄일 수 있다하여 이를 활용해 문제 풀이
public class B1932 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];

        for (int i = 0; i < N; i++) {
            arr[i] = new int[i+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
            }
        }

        System.out.println(arr[0][0]);
    }
}
