import java.io.*;
// 밟는 계단에 따라 점화식을 세우는 문제
// N의 범위 때문에 조건문에 i가 2, 3일 때를 포함시켜주자
public class B2579 {
    static int N;
    static int[] arr;
    static int[] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        DP = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DP[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            if (i == 2){
                DP[2] = arr[1] + arr[2];
            } else if (i == 3) {
                DP[3] = Math.max(arr[1], arr[2]) + arr[3];
            } else {
                DP[i] = Math.max(DP[i-3] + arr[i-1], DP[i-2]) + arr[i];
            }
        }
        System.out.println(DP[N]);
    }
}
