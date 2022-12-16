public class P140107 {

    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            long X = (long) i*i;
            long D = (long) d*d;
            int Y = (int)Math.sqrt(D - X);
            answer += (Y/k)+1;
        }
        return answer;
    }
}
