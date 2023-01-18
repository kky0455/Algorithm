import java.io.*;
import java.util.*;

public class B1654 {
    private static long binary(long arr[], int N, long maxV) {
        long minV = 1;

        while (minV <= maxV) {
            long midV = (minV + maxV) / 2;
            long cnt = 0;
            for (long num : arr) {
                cnt += num / midV;
            }
            if (cnt < N) {
                maxV = midV-1;
            } else {
                minV = midV+1;
            }
        }
        return (maxV+minV)/2;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long answer = 0;
        long maxV = 0;

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxV = Math.max(maxV, arr[i]);
        }

        answer = binary(arr, N, maxV);

        System.out.println(answer);
    }

}
