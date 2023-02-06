import sys
input = sys.stdin.readline

n=int(input())
lst= list()

for i in range(n):
    lst.append(list(map(int, input().split())))

def check(s, y, x):
    mid=s//2
    if s==2:
        answer=[lst[y][x], lst[y+1][x], lst[y][x+1], lst[y+1][x+1]]
        answer.sort()
        return answer[-2]
    
    lt=check(mid, y, x)
    rt=check(mid, y+mid, x)
    lb=check(mid, y, x+mid)
    rb=check(mid, y+mid, x+mid)
    answer=[lt, rt, lb, rb]
    answer.sort()
    return answer[-2]

print(check(n, 0, 0))