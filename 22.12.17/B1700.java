import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1700 {
    public static void main(String[] args) throws IOException {
        int ans = 0;
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[K+1];
        int[] lst = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            if (!check[lst[i]]) {
                if (cnt < N) {
                    check[lst[i]] = true;
                    cnt++;
                } else {
                    int[] visited = new int[K+1];
                    for (int j = 1; j <=K; j++) {
                        if (check[j]) {
                            visited[j] = 101;
                        }
                    }
                    for (int j = i+1; j < K; j++) {
                        if (visited[lst[j]] == 101){
                            visited[lst[j]] = j;
                        }
                    }
                    int target = 0;
                    for (int j = 1; j <= K; j++) {
                        if (visited[j] > visited[target]) {
                            target = j;
                        }
                    }
                    check[target] = false;
                    ans++;
                    check[lst[i]] = true;
                }
            }
        }
        System.out.println(ans);
    }
}
