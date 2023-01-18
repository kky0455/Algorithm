# 외판원의 순회 2

1. 도시의 수 N과 각 도시간 이동하는 비용의 행렬이 주어진다.
2. 도시를 순회하며 처음으로 돌아올 때 가장 적게 발생하는 비용을 구하기
3. DFS를 이용하여 탐색을 진행했고, 백트래킹을 적용하여 탐색 시간을 줄였다.

```python
def dfs(idx, sumV, cnt):
    global answer, start
    if sumV >= answer:
        return
    if cnt == N:
        if G[idx][start] == 0:
            return
        if sumV + G[idx][start] < answer:
            answer = sumV + G[idx][start]
        return
    for i in range(N):
        if G[idx][i] != 0 and not visited[i]:
            visited[i] = 1
            dfs(i, sumV+G[idx][i], cnt+1)
            visited[i] = 0
```
- 백드래킹을 활용해 현재 정답보다 비용이 더 소요된다면 돌아가기
- 도시를 모두 순회한 경우 정답과 비교하여 적은 비용 찾기
- 배열을 순회하며 dfs를 진행