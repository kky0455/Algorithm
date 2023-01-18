import sys
input = sys.stdin.readline

N, M = map(int, input().split())
lst = list(map(int, input().split()))
answer = 10000000    

minV = max(lst)
maxV = sum(lst)

while minV <= maxV:
    midV = (minV + maxV)//2
    cnt = 0
    sumV = 0
    for i in range(N):
        if sumV + lst[i] <= midV:
            sumV += lst[i]
        else:
            sumV = lst[i]
            cnt += 1
    if cnt+1 > M:
        minV = midV+1
    else:
        answer = min(answer, midV)
        maxV = midV-1
        
print(answer)