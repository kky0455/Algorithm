# 연구소

1. 벽을 3개 설치해 상하좌우로 퍼지는 바이러스를 최대한 막는 문제
2. 배열을 돌며 빈 칸인 경우 벽을 세우기
3. 벽을 총 3개 세웠으면 bfs를 돌려 바이러스가 퍼졌을 때, 안전구역이 얼마나 되는지 카운트
4. 이 과정을 배열을 모두 탐색하며 진행하는 브루트포스 문제

```python
def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                lab[i][j] = 1
                wall(cnt+1)
                lab[i][j] = 0
```
- 배열을 돌며 빈 칸에 벽을 세우며 진행
- 3개 다 채운경우 bfs로 넘어가기

```python
def bfs():
    global answer
    safe = 0
    copyLab = copy.deepcopy(lab)
    q = deque()

    for i in range(N):
        for j in range(M):
            if copyLab[i][j] == 2:
                q.append((i, j))

```
- 기존에 주어진 배열을 유지하기위해 deepcopy사용
- bfs를 위해 바이러스가 있는 위치를 큐에 담아두자

```python
while q:
        y, x = q.popleft()
        for d in range(4):
            ny = y + dy[d]
            nx = x +dx[d]
            if 0 <= ny < N and 0 <= nx < M and copyLab[ny][nx] == 0:
                copyLab[ny][nx] = 2
                q.append((ny, nx))
    
    for i in range(N):
        for j in range(M):
            if copyLab[i][j] == 0:
                safe += 1
    
    if safe > answer:
        answer = safe
```
- bfs를 진행 후 안전지역을 카운트해 기존 답과 비교