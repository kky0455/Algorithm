import java.io.*;
import java.util.*;

// 단축키로 지정되는 알파벳에 []를 씌워 출력하는 문제
// 규칙에 맞게 입력되는 문자열의 종류에 따라 규칙을 나눠 구현한다.

public class B1283 {
    static int N;
    static String[] arr;
    static boolean[] alp = new boolean[26];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            if (arr[i].contains(" ")) {
                String[] w = arr[i].split(" ");
                for (int j = 0; j < w.length; j++) {
                    if (!alp[Character.toUpperCase(w[j].charAt(0)) - 65]) {
                        alp[Character.toUpperCase(w[j].charAt(0)) - 65] = true;
                        w[j] = "[" + w[j].charAt(0) + "]" + w[j].substring(1);
                        flag = true;
                        break;
                    }
                }
                arr[i] = String.join(" ", w);

                if (!flag) {
                    for (int j = 0; j < arr[i].length(); j++) {
                        if (arr[i].charAt(j) != ' ' && !alp[Character.toUpperCase(arr[i].charAt(j)) - 65]) {
                            alp[Character.toUpperCase(arr[i].charAt(j)) - 65] = true;
                            arr[i] = arr[i].substring(0, j) + "[" + arr[i].charAt(j) + "]" + arr[i].substring(j + 1);
                            break;
                        }
                    }
                }
            } else {
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) != ' ' && !alp[Character.toUpperCase(arr[i].charAt(j)) - 65]) {
                        alp[Character.toUpperCase(arr[i].charAt(j)) - 65] = true;
                        arr[i] = arr[i].substring(0, j) + "[" + arr[i].charAt(j) + "]" + arr[i].substring(j + 1);
                        break;
                    }
                }
            }
        }
        for (String i : arr) {
            System.out.println(i);
        }
    }
}
