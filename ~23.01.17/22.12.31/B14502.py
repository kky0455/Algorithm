from collections import deque
import copy

N, M = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(N)]
answer = 0

dy = [0, 0, -1, 1]
dx = [-1, 1, 0, 0]

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
    
def bfs():
    global answer
    safe = 0
    copyLab = copy.deepcopy(lab)
    q = deque()

    for i in range(N):
        for j in range(M):
            if copyLab[i][j] == 2:
                q.append((i, j))

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
    
wall(0)

print(answer)