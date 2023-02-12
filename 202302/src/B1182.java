import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 부분수열의 합 구하기
// 부분수열을 구해 목표값과 일치하는 경우의 수가 몇개인지 구하자
// 0의 존재를 고려해 함부로 백트래킹을 쓰지 말기
public class B1182 {
    static int N;
    static int S;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++){
            find(i+1, arr[i]);
        }
        System.out.println(answer);
    }
    private static void find(int idx, int sumV) {
        if (sumV == S) answer++;
        if (idx == N) return;
        for (int i = idx; i < N; i++){
            find(i+1, sumV+arr[i]);
        }
    }
}
