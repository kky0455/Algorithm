import sys
input = sys.stdin.readline

N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]
DP = [[0] * (1 << N-1) for _ in range(N)]

def find(idx, bit):
    if DP[idx][bit] != 0:
        return DP[idx][bit]

    if bit == (1 << (N-1)) -1:
        if W[idx][0]:
            return W[idx][0]
        else:
            return float('inf')
    
    minV = float('inf')

    for i in range(1, N):
        if not W[idx][i]:
            continue
        if bit & (1 << i-1):
            continue
        cost = W[idx][i] + find(i, bit | (1<<(i-1)))
        if minV > cost:
            minV = cost

    DP[idx][bit] = minV

    return minV

print(find(0, 0))

