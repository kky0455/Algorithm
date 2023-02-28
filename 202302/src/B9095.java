import java.io.*;
// 10까지의 숫자를 1, 2, 3을 활용해 만들 수 있는 식의 개수를 구하기
// 점화식을 활용하면 쉽게 구할 수 있음
public class B9095 {
    static int T;
    static int N;
    static int[] DP = new int[11];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        for (int i = 4; i < 11; i++) {
            DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
        }
        for (int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            System.out.println(DP[N]);
        }
    }
}