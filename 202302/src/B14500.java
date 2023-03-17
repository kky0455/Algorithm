import java.io.*;
import java.util.*;
// 4개의 블록으로 만들 수 있는 모양을 합치면 3칸 이내로 갈 수 있는 범위의 합이 된다.
// 그 외 블록만 따로 지정해서 값을 구하면 최대값을 구할 수 있다.
public class B14500 {
    static int maxV = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(maxV);
    }

    private static void dfs(int y, int x, int sumV, int cnt) {
        if (cnt == 4) {
            maxV = Math.max(maxV, sumV);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (cnt == 2) {
                        dfs(y, x, sumV+arr[ny][nx], cnt+1);
                    }
                    dfs(ny, nx, sumV+arr[ny][nx], cnt+1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
