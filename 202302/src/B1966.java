import java.util.*;
import java.io.*;

public class B1966 {
    static int T, N, M;
    static Queue<Integer> q;
    static Queue<Integer> idx;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            idx = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                q.offer(Integer.parseInt(st.nextToken()));
                idx.offer(j);
            }
            check();
        }
    }

    private static void check() {
        int cnt = 1;

        while (!q.isEmpty()) {
            int maxV = Collections.max(q);
            int cur = q.poll();
            int now = idx.poll();

            if (cur == maxV) {
                if (now == M) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }
            else {
                q.offer(cur);
                idx.offer(now);
            }
        }
    }
}
