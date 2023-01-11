import java.util.*;
import java.io.*;
public class B2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int minV = 0;
        int maxV = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i =0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxV = Math.max(maxV, arr[i]);
        }
        while (minV <= maxV) {
            int midV = (minV + maxV) / 2;
            long sumV = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > midV) {
                    sumV += arr[i] - midV;
                }
            }
            if (M <= sumV) {
                minV = midV+1;
                if (midV > answer) {
                    answer = midV;
                }
            }else {
                maxV = midV-1;
            }
        }
        System.out.println(answer);
    }
}
