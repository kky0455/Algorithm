import java.util.*;
import java.io.*;
// 벨트의 회전, 로봇의 움직임에 맞춰 정해진 내용을 구현하는 문제
public class B20055 {
    static int N, K;
    static int[] A;
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        while (flag()){
            bMove();
            rMove();
            answer++;
        }
        System.out.println(answer);
    }

    private static boolean flag() {
        int cnt = 0;
        for (int i=0; i<2*N; i++) {
            if (A[i]==0){
                cnt++;
            }
            if (cnt >= K){
                return false;
            }
        }
        return true;
    }

    private static void rMove(){
        check[N-1] = false;

        for (int i = N-1; i > 0; i--) {
            if (!check[i] && check[i-1] && A[i] >= 1) {
                check[i] = true;
                check[i-1] = false;
                A[i]--;
            }
        }
        if (A[0] > 0) {
            check[0] = true;
            A[0]--;
        }
    }

    private static void bMove() {
        int tmp = A[2*N-1];

        for (int i = 2*N-1; i > 0; i--) {
            A[i] = A[i-1];
        }
        A[0] = tmp;

        for (int i = N-1; i>0; i--) {
            check[i] = check[i-1];
        }
        check[0] = false;
    }
}
