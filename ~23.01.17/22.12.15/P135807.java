import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P135807 {

    private List<Integer> divisors;

    private int find(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        divisors = new ArrayList<>();

        for (int i =2; i*i <= arr1[0]; i++) {
            if (arr1[0] % i == 0) {
                divisors.add(i);
                divisors.add(arr1[0]/i);
            }
        }
        divisors.add(arr1[0]);

        Collections.sort(divisors, Collections.reverseOrder());


        for (int div : divisors) {
            if (check1(div, arr1) && check2(div, arr2)) {
                return div;
            }
        }

        return 0;
    }

    private boolean check1(int div, int[] arr) {
        for (int val : arr) {
            if (val % div != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean check2(int div, int[] arr) {
        for (int val : arr) {
            if (val % div == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int num;

        num = find(arrayA, arrayB);
        if (answer < num) {
            answer = num;
        }

        num = find(arrayB, arrayA);
        if (answer < num) {
            answer = num;
        }
        return answer;
    }
}
