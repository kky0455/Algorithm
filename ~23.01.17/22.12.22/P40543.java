import java.util.*;

public class P40543 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(people);
        for (int i = people.length-1; i >= 0; i--) {
            lst.add(people[i]);
        }
        Deque<Integer> deque = new ArrayDeque<>(lst);
        while (!deque.isEmpty()) {
            int sumV = deque.peekFirst() + deque.peekLast();
            if (sumV > limit) {
                deque.pollFirst();
                answer++;
            } else {
                deque.pollFirst();
                deque.pollLast();
                answer++;
            }
            if (!deque.isEmpty()) {
                if (deque.peekLast() > Math.ceil((double) limit/2.0)) {
                    break;
                }
            }

        }
        if (!deque.isEmpty()) {
            answer += deque.size();
        }

        return answer;
    }
}
