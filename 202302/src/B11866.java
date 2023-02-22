import java.util.*;
import java.io.*;
// 큐를 사용해 규칙에 맞는 수를 차례로 출력하자
public class B11866 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        System.out.print("<");

        while (q.size() > 1){
            for (int i = 0; i < K-1; i++){
                q.offer(q.poll());
            }
            System.out.print(q.poll()+", ");
        }
        System.out.print(q.poll()+">");
    }
}
