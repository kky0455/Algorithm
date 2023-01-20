import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 컴퓨터를 최대한 많이 해킹하는 문제
// 각 컴퓨터를 LinkedList로 연결하고, bfs를 돌려 구현
// 자바에서는 시초가 많이 난다하고 실제로 나도 시초가 났는데...왜??? ㅎㅎ;;;
public class B1325 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr.get(A).add(B);
        }
        answer = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];;
            bfs(i);
        }

        int maxV = 0;

        for (int i = 1; i <= N; i++) {
            maxV = Math.max(maxV, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxV) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        while (!q.isEmpty()){
            int v = q.poll();
            for (int i : arr.get(v)){
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    answer[i]++;
                }
            }
        }
    }
}
