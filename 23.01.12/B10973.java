import java.util.*;
import java.io.*;

public class B10973 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (check(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean check(int[] arr) {
        int i = arr.length-1;
        while (i > 0 && arr[i-1] < arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = arr.length-1;
        while (arr[j] > arr[i-1]) {
            j--;
        }
        swap(arr, i-1, j);

        j = arr.length-1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
