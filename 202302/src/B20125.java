import java.util.*;
import java.io.*;

// 쿠키의 심장을 기준으로 왼팔, 오른팔, 허리, 왼다리, 오른다리의 길이를 구하는 문제
// 모든 과정을 구현했다.

public class B20125 {
    static int N;
    static String[][] arr;
    static int heartY;
    static int heartX;
    static int[] answer = new int[5];
    static int waistY;
    static int waistX;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++){
                arr[i][j] = s[j];
            }
        }
        heart();
        int leftA = 0;
        int rightA = 0;
        int waist = 0;
        for (int i = 1; i < N; i++) {
            if (heartX-i >= 0 && arr[heartY][heartX-i].charAt(0) == '*'){
                leftA++;
            }
        }
        answer[0] = leftA;
        for (int i = 1; i < N; i++) {
            if (heartX+i < N && arr[heartY][heartX+i].charAt(0) == '*'){
                rightA++;
            }
        }
        answer[1] = rightA;
        for (int i = 1; i < N; i++) {
            if (arr[heartY+i][heartX].charAt(0) == '*') {
                waist++;
            }else {
                answer[2] = waist;
                waistY = heartY+i-1;
                waistX = heartX;
                leg();
                break;
            }
        }
        System.out.println((heartY+1)+" "+(heartX+1));
        for (int a : answer) {
            System.out.print(a+" ");
        }
    }

    private static void heart(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if (arr[i][j].charAt(0) == '*'){
                    heartY = i+1;
                    heartX = j;
                    return;
                }
            }
        }
    }

    private static void leg(){
        int leftL = 0;
        int rightL = 0;
        for (int i = 1; i < N; i++) {
            if (waistY+i < N && arr[waistY+i][waistX-1].charAt(0) == '*') {
                leftL++;
            }
        }
        answer[3] = leftL;
        for (int i = 1; i < N; i++) {
            if (waistY+i < N && arr[waistY+i][waistX+1].charAt(0) == '*') {
                rightL++;
            }
        }
        answer[4] = rightL;
    }
}
