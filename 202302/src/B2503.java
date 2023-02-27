import java.util.*;
import java.io.*;
// 숫자야구 문제
// 중복숫자, 0이 없는 숫자들 중 질문의 스트라이크, 볼의 횟수가 같은 정답의 수를 구하자
public class B2503 {
    static int N;
    static List<info> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            info inf = new info(num, s, b);

            arr.add(inf);
        }

        System.out.println(check());
    }

    static int check() {
        int answer  = 0;

        for (int i = 123; i <= 987; i++) {
            if (!dupleCheck(i)) continue;

            int cnt = 0;

            for (int j = 0; j < N; j++) {
                int sCnt = 0;
                int bCnt = 0;

                info now = arr.get(j);
                String str = Integer.toString(now.num);
                String num2 = Integer.toString(i);

                for (int k = 0; k < 3; k++) {
                    if (str.charAt(k) == num2.charAt(k)){
                        sCnt++;
                    } else {
                        for (int l = 0; l < 3; l++) {
                            if (str.charAt(k) == num2.charAt(l)) {
                                bCnt++;
                            }
                        }
                    }
                }

                if (now.s == sCnt && now.b == bCnt) {
                    cnt++;
                }
            }
            if (cnt == N) {
                answer++;
            }
        }
        return answer;
    }

    static boolean dupleCheck(int val) {
        String str = Integer.toString(val);

        if (str.charAt(0) == str.charAt(1)) {
            return false;
        }
        if (str.charAt(0) == str.charAt(2)) {
            return false;
        }
        if (str.charAt(1) == str.charAt(2)) {
            return false;
        }
        if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0'){
            return false;
        }
        return true;
    }

    static class info {
        int num;
        int s;
        int b;

        public info(int num, int s, int b){
            this.num = num;
            this.s = s;
            this. b = b;
        }
    }
}
