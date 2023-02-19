import java.util.*;
import java.io.*;
// 톱니바퀴 구현 문제
// 톱니바퀴를 회전시켰을 때 마주보는 극에 따라 조건에 맞춰 구현하는 문제
public class B14891 {
    static int[][] arr;
    static int K;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[4][8];

        for (int i = 0; i < 4; i++){
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                // 문자형 타입을 숫자로 바꾸는 과정 아스키코드 값을 빼서 만든다.
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            gear(idx-1, dir);
        }

        answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += Math.pow(2, i) * arr[i][0];
        }
        System.out.println(answer);

    }
    private static void gear(int idx, int dir) {
        left(idx-1, -dir);
        right(idx+1, -dir);
        lotation(idx, dir);
    }

    private static void left(int idx, int dir) {
        if (idx < 0) return;
        if (arr[idx][2] == arr[idx+1][6]) return;
        left(idx-1, -dir);
        lotation(idx, dir);
    }

    private static void right(int idx, int dir) {
        if (idx > 3) return;
        if (arr[idx][6] == arr[idx-1][2]) return;
        right(idx+1, -dir);
        lotation(idx, dir);
    }

    private static void lotation(int idx, int dir){
        if (dir==1) {
            int tmp = arr[idx][7];
            for (int i = 7; i > 0; i--) {
                arr[idx][i] = arr[idx][i-1];
            }
            arr[idx][0] = tmp;
        }else {
            int tmp = arr[idx][0];
            for (int i = 0; i < 7; i++) {
                arr[idx][i] = arr[idx][i+1];
            }
            arr[idx][7] = tmp;
        }
    }
}
