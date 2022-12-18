import java.util.HashMap;
import java.util.HashSet;

public class P132265 {

    public int solution(int[] topping) {
        int answer = 0;
        int lenTopping = topping.length;

        HashSet<Integer> lst1 = new HashSet<>();
        HashMap<Integer, Integer> lst2 = new HashMap<>();

        lst1.add(topping[0]);
        for (int i = 1; i < lenTopping; i++) {
            lst2.put(topping[i], lst2.getOrDefault(topping[i], 0)+1);
        }

        for (int i = 1; i < lenTopping; i++) {
            lst1.add(topping[i]);
            lst2.put(topping[i], lst2.get(topping[i])-1);
            if (lst2.get(topping[i]) == 0) {
                lst2.remove(topping[i]);
            }
            if (lst1.size() == lst2.size()) {
                answer++;
            }
        }
        return answer;
    }
}
