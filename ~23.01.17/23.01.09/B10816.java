import java.util.*;
import java.io.*;

public class B10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(numOver(arr, num) - findNum(arr, num)).append(' ');
        }
        System.out.println(sb);
    }

    private static int findNum(int[] arr, int num) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l+r)/2;

            if (num <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int numOver(int[] arr, int num) {
        int l =0;
        int r = arr.length;

        while (l <r) {
            int mid = (l+r)/2;

            if (num < arr[mid]) {
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
