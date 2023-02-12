import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 그리드 문제
// 물 새는 곳의 조건을 고려해 테이핑을 최소화하기
// 주어진 위치를 정렬한 후 차례로 탐색해 테이핑이 필요한 곳의 개수를 구하자
public class B1449 {
    static int N;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        double end = arr[0] - 0.5 + L;
        answer++;
        for (int i = 1; i < N; i++){
            if (arr[i] + 0.5 > end) {
                end = arr[i] - 0.5 + L;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
