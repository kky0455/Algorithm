import java.util.*;

public class P42583 {
    Queue<Integer> queue = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sumW = 0;
        for (int truck_weight: truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck_weight);
                    sumW += truck_weight;
                    answer++;
                    break;
                }
                if (queue.size() == bridge_length) {
                    sumW -= queue.poll();
                } else {
                    if (sumW + truck_weight <= weight) {
                        queue.add(truck_weight);
                        sumW += truck_weight;
                        answer++;
                        break;
                    } else {
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
