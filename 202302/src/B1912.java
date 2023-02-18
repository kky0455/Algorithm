import java.util.*;
import java.io.*;
// DP를 활용해 연속합의 최대값을 구하는문제
// 연속합이 0이하로 떨어지면 다음 인덱스부터 새로운 연속합을 구한다.
// 연속합을 진행하며 최대값을 갱신해 답을 출력하자
public class B1912 {
    static int N;
    static int[] arr;
    static int answer = -1000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] DP = new int[N];
        DP[0] = arr[0];
        answer = arr[0];
        for (int i = 1; i < N; i++){
            if (DP[i-1] <= 0 && arr[i] > 0) {
                DP[i] = arr[i];
                continue;
            }
            if (DP[i-1] + arr[i] <= 0) {
                DP[i] = arr[i];
            }else {
                DP[i] = DP[i-1] + arr[i];
            }
            if (answer < DP[i]) {
                answer = DP[i];
            }
        }
        System.out.println(answer);
    }
}
