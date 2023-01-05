# 외판원의 순회

1. 비트마스크를 활용해 노드 방문을 체크
2. 출발지의 정보를 담기 위해 2차원 dp를 활용
3. 재귀를 활용해 방문이 가능한 도시인 경우 탐색을 계속 이어나간다.

```python
    if bit == (1 << (N-1)) -1:
        if W[idx][0]:
            return W[idx][0]
        else:
            return float('inf')
```
- 모든 경로를 돌았을 때, 시작 위치로 갈 수 있는 경우 판단

```python
    minV = float('inf')

    for i in range(1, N):
        if not W[idx][i]:
            continue
        if bit & (1 << i-1):
            continue
        cost = W[idx][i] + find(i, bit | (1<<(i-1)))
        if minV > cost:
            minV = cost
```
- 갈 수 없는 경로이거나 이미 방문한 경우를 제외
- DFS를 통해 DP값을 갱신시키며 최소값을 찾는다.