import java.util.*;
import java.io.*;
// 집과 치킨집의 거리를 기준 M개의 치킨집을 남겨 치킨거리의 값이 최소가 되게 구현
// M개의 치킨집의 거리 최소값을 구하고 백트래킹을 활용해 시간단축
public class B15686 {
    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<int[]> H = new ArrayList<>();
    static ArrayList<int[]> C = new ArrayList<>();
    static ArrayList<int[]> menu = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    H.add(new int[]{i, j});
                }
                if (arr[i][j] == 2) {
                    C.add(new int[] {i, j});
                }
            }
        }
        visited = new boolean[C.size()];

        check(0,0);
        System.out.println(answer);
    }

    static void check(int d, int s) {
        if (d == M) {
            int sumV = 0;
            for (int[] h : H) {
                int minV = Integer.MAX_VALUE;
                for (int[] m : menu) {
                    int dis = Math.abs(h[0] - m[0]) + Math.abs(h[1] - m[1]);
                    minV = Math.min(dis, minV);
                }
                sumV += minV;
            }
            answer = Math.min(answer, sumV);
            return;
        }

        for (int i = s; i < C.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                menu.add(C.get(i));
                check(d+1, i+1);
                menu.remove(menu.size()-1);
                visited[i] = false;
            }
        }
    }
}
