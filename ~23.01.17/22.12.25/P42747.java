import java.util.Arrays;

public class P42747 {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = Math.min(citations[i], citations.length-i);

            if (h >= answer) {
                answer = Math.max(h, answer);
            } else {
                break;
            }
        }
        return answer;
    }
}
