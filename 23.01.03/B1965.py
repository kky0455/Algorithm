n = int(input())
boxes = list(map(int, input().split()))

DP = [1] * n

for i in range(1, n):
    maxV = 0
    for j in range(0, i):
        if DP[j] > maxV and boxes[j] < boxes[i]:
            maxV = DP[j]
    DP[i] += maxV

print(max(DP))