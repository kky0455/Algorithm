# 땅따먹기

1. 행을 따라 내려오면서 가장 큰 숫자를 만들기
2. 같은 열을 연속해서 밟을 수 없는 규칙이 존재
3. 행의 개수가 많으므로 DP를 활용하여 효율성을 챙기자

```java
for (int i = 1; i< land.length; i++) {
    land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
    land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
    land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
    land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
}
for (int i = 0; i < 4; i++) {
    answer = Math.max(answer, land[land.length-1][i]);
}
```

- 주어진 배열을 돌며 이전 값 중 가장 큰 값을 찾아 누적합 진행하기
- 마지막에는 4개의 값을 돌며 최대값 찾기