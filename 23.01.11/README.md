# 나무 자르기

1. 절단기의 높이를 설정해 최소 M미터의 나무를 가져가려는 문제
2. 이분 탐색을 활용해 풀이하자.

```java
while (minV <= maxV) {
    int midV = (minV + maxV) / 2;
    long sumV = 0;
    for (int i = 0; i < N; i++) {
        if (arr[i] > midV) {
            sumV += arr[i] - midV;
        }
    }
    if (M <= sumV) {
        minV = midV+1;
        if (midV > answer) {
            answer = midV;
        }
    }else {
        maxV = midV-1;
    }
}
```
- 최소, 최대값을 기반으로 절단기의 값을 구하고 이분 탐색을 진행
- 얻을 수 있는 나무가 M보다 많거나 같다면 최소를 변경
- 얻을 수 있는 나무가 M보다 적다면 최대 길이를 변경