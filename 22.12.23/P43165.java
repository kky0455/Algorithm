public class P43165 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, target, 0, numbers);
        return answer;
    }

    public void dfs(int idx, int target, int sumV, int[] arr) {
        if (idx == arr.length) {
            if (target == sumV) {
                answer++;
            }
            return;
        }
        dfs(idx+1, target, sumV + arr[idx], arr);
        dfs(idx+1, target, sumV - arr[idx], arr);
    }
}
