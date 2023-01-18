import java.util.PriorityQueue;

public class P42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int sco : scoville) {
            priorityQueue.add(sco);
        }

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }
            int food1 = priorityQueue.poll();
            int food2 = priorityQueue.poll();

            int food3 = food1 + (food2 * 2);

            priorityQueue.offer(food3);
            answer++;
        }

        return answer;
    }
}
