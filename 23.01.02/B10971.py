import sys
input = sys.stdin.readline

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

N = int(input())
G = []
answer = 100000000
visited = [0] * N
start = -1
for _ in range(N):
    G.append(list(map(int,input().split())))

for i in range(N):
    start = i
    visited[i] = 1
    dfs(i, 0, 1)
    visited[i] = 0

print(answer)