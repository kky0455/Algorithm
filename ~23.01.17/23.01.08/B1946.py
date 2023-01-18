import sys
input = sys.stdin.readline

T = int(input())

for tc in range(T):
    N = int(input())
    answer = 1
    score = [list(map(int, input().split())) for _ in range(N)]
    score = sorted(score, key=lambda a:a[0])
    rank = score[0][1]
    for i in range(1, N):
        if score[i][1] < rank:
            rank = score[i][1]
            answer += 1
        
    print(answer)