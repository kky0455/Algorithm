import java.util.*;
import java.io.*;
// 가로, 세로방향을 순회하며 2글자 이상인 단어를 찾아 저장하고 첫번째 단어를 출력하기
public class B3005 {
    static int r;
    static int c;
    static String[][] arr;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static ArrayList<String> lst = new ArrayList<String>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];

        for (int i =0; i < r; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = s[j];
            }
        }
        check1();
        check2();

        Collections.sort(lst);

        System.out.println(lst.get(0));
    }

    private static void check1(){
        int len;
        for (int i = 0; i<r; i++) {
            String tmp = "";
            len = 0;
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("#")) {
                    if (len >= 2) {
                        lst.add(tmp);
                    }
                    len = 0;
                    tmp = "";
                } else {
                    tmp += arr[i][j];
                    len++;
                }
            }
            if (tmp.length() >= 2) {
                lst.add(tmp);
            }
        }
    }

    private static void check2(){
        int len;
        for (int i = 0; i<c; i++) {
            String tmp = "";
            len = 0;
            for (int j = 0; j < r; j++) {
                if (arr[j][i].equals("#")) {
                    if (len >= 2) {
                        lst.add(tmp);
                    }
                    len = 0;
                    tmp = "";
                } else {
                    tmp += arr[j][i];
                    len++;
                }
            }
            if (tmp.length() >= 2) {
                lst.add(tmp);
            }
        }
    }
}
