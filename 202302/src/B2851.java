import java.util.*;
import java.io.*;
// 10개의 입력을 받아 더하면서 가장 100과 근접한 수를 찾는 문제
public class B2851 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sumV = 0;
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            if (Math.abs(sumV + val - 100) <= Math.abs(sumV - 100)) {
                answer = sumV + val;
            }
            sumV += val;
        }
        System.out.println(answer);
    }
}
