import java.util.*;
import java.io.*;
// 겉넓이 구하는 문제
// 맨 앞의 면적은 그냥 더한 후 뒷 쪽 높이와의 차를 빼준다.
// 이 차이가 양수일 때 겉넓이에 더한다.
// 이를 동서남북으로 구하고 위, 아래는 그냥 면적 넓이 더하기
public class B16931 {
    static int N;
    static int M;
    static int[][] arr;
    static int sumV = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    sumV++;
                }
            }
        }

        sumV *= 2;

        for (int i = 0; i < N; i++) {
            for (int j = M-1; j >=1 ; j-- ) {
                int val = arr[i][j-1] - arr[i][j];
                if (val >= 0) {
                    sumV += val;
                }
            }
            sumV += arr[i][M-1];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M-2; j++) {
                int val = arr[i][j+1] - arr[i][j];
                if (val >= 0) {
                    sumV += val;
                }
            }
            sumV += arr[i][0];
        }

        for (int j = 0; j < M; j++) {
            for (int i = 0; i <= N-2; i++) {
                int val = arr[i+1][j] - arr[i][j];
                if (val >= 0) {
                    sumV += val;
                }
            }
            sumV += arr[0][j];
        }

        for (int j = 0; j < M; j++) {
            for (int i = N-1 ; i >= 1; i-- ){
                int val = arr[i-1][j] - arr[i][j];
                if (val >= 0){
                    sumV += val;
                }
            }
            sumV += arr[N-1][j];
        }

        System.out.println(sumV);
    }
}
