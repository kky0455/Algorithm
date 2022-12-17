# 멀티탭 스케줄링

1. 각 기기들이 멀티탭에 연결됐는지 기록하는 리스트 생성
2. 입력값을 차례로 돌며 멀티탭이 남는 자리가 없을 경우 다음에 뺄 기기를 정하기

```java
for (int j = 1; j <=K; j++) {
    if (check[j]) {
        visited[j] = 101;
    }
}
for (int j = i+1; j < K; j++) {
    if (visited[lst[j]] == 101){
        visited[lst[j]] = j;
    }
}
int target = 0;
for (int j = 1; j <= K; j++) {
    if (visited[j] > visited[target]) {
        target = j;
    }
}
```

- 처음 for문은 멀티탭에 연결된 기기들에 최대값(사용횟수는 최대 100)을 지정
- 다음 for문은 이후에 연결할 기기들을 순회하며 그 기기에 해당하는 인덱스로 변경
- visited를 순회하며 가장 높은 수를 가진 기기가 우선순위가 낮으므로 해당 기기의 연결을 제거한다.