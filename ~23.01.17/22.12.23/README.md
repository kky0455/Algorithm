# 타겟 넘버

1. 주어진 정수들을 더하거나 빼서 원하는 숫자로 만드는 문제
2. dfs를 이용해 숫자를 순서대로 계산하여 마지막에 목표하는 숫자인지 판단해 답을 카운트

```java
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
```

- 인덱스, 목표값, 누적값, 배열을 인자로 전달
- 주어진 모든 정수를 사용했으면 목표값과 누적값을 비교
- 아니면 dfs를 계속 진행