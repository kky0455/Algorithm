import java.util.*;
import java.io.*;

// 입력으로 주어진 배열을 주어진 횟수만큼 연산번호 규칙을 적용하는 문제

public class B16935 {
    static int N;
    static int M;
    static int R;
    static int[][] arr;
    static int[][] answer;
    static int num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<R; i++){
            num = Integer.parseInt(st.nextToken());
            if (num == 1){
                one();
            } else if (num == 2) {
                two();
            } else if (num == 3) {
                three();
            } else if (num == 4) {
                four();
            } else if (num == 5) {
                five();
            } else {
                six();
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j<M; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void one() {
        answer = new int[N][M];
        for (int i = 0; i<N; i++){
            for (int j = 0; j < M; j++){
                answer[N-i-1][j] = arr[i][j];
            }
        }
        arr = answer;
    }
    public static void two() {
        answer = new int[N][M];
        for (int i = 0; i<N; i++){
            for (int j = 0; j < M; j++){
                answer[i][M-j-1] = arr[i][j];
            }
        }
        arr = answer;
    }
    public static void three() {
        answer = new int[M][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j < M; j++){
                answer[j][N-i-1] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        arr = answer;
    }
    public static void four() {
        answer = new int[M][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j < M; j++){
                answer[M-j-1][i] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        arr = answer;
    }
    public static void five() {
        answer = new int[N][M];

        int n = N/2;
        int m = M/2;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                answer[i][m+j] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = m; j < M; j++){
                answer[n+i][j] = arr[i][j];
            }
        }

        for (int i = n; i < N; i++) {
            int val = 0;
            for (int j = m; j < M; j++){
                answer[i][val] = arr[i][j];
                val++;
            }
        }

        int row = 0;

        for (int i = n; i < N; i++){
            for (int j = 0; j < m; j++){
                answer[row][j] = arr[i][j];
            }
            row++;
        }
        arr = answer;
    }
    public static void six() {
        answer = new int[N][M];

        int n = N/2;
        int m = M/2;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                answer[n+i][j] = arr[i][j];
            }
        }

        for (int i = n; i < N; i++){
            for (int j = 0; j < m; j++){
                answer[i][m+j] = arr[i][j];
            }
        }

        int row = 0;
        for (int i = n; i < N; i++){
            for (int j = m; j < M; j++) {
                answer[row][j] = arr[i][j];
            }
            row++;
        }

        for (int i = 0; i < n; i++) {
            int col = 0;
            for (int j = m; j < M; j++){
                answer[i][col] = arr[i][j];
                col++;
            }
        }
        arr = answer;
    }
}
