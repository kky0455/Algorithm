import java.util.*;
import java.io.*;
// 구현문제
// 맨 좌측과 우측은 빗물이 고일 수 없다.
// 고인 빗물을 구하려는 지점의 좌, 우를 따로 분석해서 고일 수 있는 최대 높이를 구하자
public class B14719 {
    static int H;
    static int W;
    static int[] info;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        info = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W-1; i++){
            int l = 0;
            int r = 0;

            for (int j = 0; j < i; j++) {
                l = Math.max(info[j], l);
            }

            for (int j = i+1; j < W; j++) {
                r = Math.max(info[j], r);
            }

            if (info[i] < l && info[i] < r) {
                answer += Math.min(l, r) - info[i];
            }
        }
        System.out.println(answer);
    }
}
