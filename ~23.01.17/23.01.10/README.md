# 랜선 자르기

1. 주어지는 K개의 랜선을 활용해 N개의 같은 길이의 랜선을 만드는 문제
2. 이분탐색으로 범위를 줄여가며 원하는 길이를 찾기
3. midV의 값으로 만들어진 랜선을 카운트하고 N과 비교해 원하는 값을 찾자.

```java
private static long binary(long arr[], int N, long maxV) {
    long minV = 1;
    
    while (minV <= maxV) {
        long midV = (minV + maxV) / 2;
        long cnt = 0;
        for (long num : arr) {
            cnt += num / midV;
        }
        if (cnt < N) {
            maxV = midV-1;
        } else {
            minV = midV+1;
        }
    }
    return (maxV+minV)/2;
}
```
- cnt와 N을 비교
- cnt < N인 경우, 길이를 더 짧게 만들어야함
- cnt > N인 경우, 더 길게 만들어야함