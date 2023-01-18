import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orange {
    private Map<Integer, Integer> map;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        for (Map.Entry<Integer,Integer> entry : entryList) {
            if (k <= 0) {
                break;
            }
            answer++;
            k -= entry.getValue();
        }

        return answer;
    }
}
