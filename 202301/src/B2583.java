import java.util.*;
import java.io.*;

// 주어진 영역을 채우고 map을 탐색하여 빈공간을 채운다.
// 탐색한 빈 공간이 아직 방문하지 않았으면 bfs를 통해 연결된 공간을 모두 카운트해 정답 리스트에 넣는다.
// 이후, 탐색이 끝난 뒤 정답 리스트를 정렬해 답을 출력한다.

public class B2583 {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int M;
    static int N;
    static int K;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++){
                for (int x = x1; x < x2; x++){
                    map[y][x] = 1;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j =0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    int ans = bfs(i, j);
                    answer.add(ans);
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }
        System.out.println(sb);
    }

    private static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {y, x});
        visited[y][x] = true;
        int cnt = 1;

        while (!q.isEmpty()){
            int[] val = q.poll();
            int Y = val[0];
            int X = val[1];

            for (int i = 0; i < 4; i++) {
                int nY = Y + dy[i];
                int nX = X + dx[i];

                if (nY >= 0 && nX >= 0 && nY < M && nX < N) {
                    if (!visited[nY][nX] && map[nY][nX] == 0) {
                        visited[nY][nX] = true;
                        q.offer(new int[] {nY, nX});
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }
}
