import java.util.Stack;

public class P131704 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subContainer = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            if (order[answer] != i) {
                subContainer.add(i);
                continue;
            }

            answer++;

            while (subContainer.size() != 0 && order[answer] == subContainer.peek()) {
                subContainer.pop();
                answer++;
            }
        }
        return answer;
    }
}
