import sys
input = sys.stdin.readline

W, N = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
answer = 0
lst = sorted(lst, key=lambda a:a[1], reverse=True)

for i in range(len(lst)):
    if W > lst[i][0]:
        W -= lst[i][0]
        answer += (lst[i][0] * lst[i][1])
    elif W <= lst[i][0]:
        answer += (W * lst[i][1])
        break
print(answer)