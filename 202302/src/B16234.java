import java.util.*;
import java.io.*;
// 인접한 노드를 방문하기 위해 bfs 탐색을 진행
// 방문한 노드를 리스트에 넣은 후 모든 방문이 끝나면 인구 이동 시작
// 인구이동이 일어나지 않을 때 까지 진행한 후 결과 반환
public class B16234 {
    static int N, L, R;
    static int[][] arr;
    static int answer;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static boolean[][] visited;
    static ArrayList<info> lst;
    public static class info{
        int y;
        int x;
        public info(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++){
                    if (!visited[i][j]){
                        int sumV = bfs(i, j);
                        if (lst.size() > 1) {
                            change(sumV);
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println(answer);
                break;
            }else {
                answer++;
            }
        }
    }

    private static int bfs(int y, int x) {
        Queue<info> q = new LinkedList<>();
        lst = new ArrayList<>();

        q.offer(new info(y, x));
        lst.add(new info(y, x));
        visited[y][x] = true;

        int sumV = arr[y][x];
        while (!q.isEmpty()){
            info in = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = in.y + dy[i];
                int nx = in.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
                    int d = Math.abs(arr[in.y][in.x] - arr[ny][nx]);
                    if (L <= d && d <= R) {
                        q.offer(new info(ny, nx));
                        lst.add(new info(ny, nx));
                        sumV += arr[ny][nx];
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return sumV;
    }

    private static void change(int sumV) {
        int avg = sumV / lst.size();
        for (info in : lst) {
            arr[in.y][in.x] = avg;
        }
    }
}
