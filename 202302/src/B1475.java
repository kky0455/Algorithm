import java.io.*;
// 구매해야할 초의 최대값 구하기
// 6, 9는 바꿔 사용할 수 있는점을 고려해서 구하자
public class B1475 {
    static String s;
    static int[] arr = new int[9];
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num == 9) {
                arr[6]++;
            } else {
                arr[num]++;
            }
        }
        if (arr[6] % 2 == 1) {
            arr[6] = arr[6] / 2 + 1;
        } else {
            arr[6] = arr[6] / 2;
        }
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, arr[i]);
        }
        System.out.println(answer);
    }
}
