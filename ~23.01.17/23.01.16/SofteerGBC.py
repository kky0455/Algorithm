import sys
input = sys.stdin.readline

N, M = map(int, input().split())
listN = [list(map(int, input().split())) for _ in range(N)]
listM = [list(map(int, input().split())) for _ in range(M)]
answer = 0
idxN = idxM = 0

while True:
    if idxN >= len(listN) and idxM >= len(listM):
        break
    
    if listM[idxM][0] > listN[idxN][0]:
        answer = max(answer, listM[idxM][1] - listN[idxN][1])
        idxN += 1
        listN[idxN][0] += listN[idxN-1][0]

    elif listM[idxM][0] < listN[idxN][0]:
        answer = max(answer, listM[idxM][1] - listN[idxN][1])
        idxM += 1
        listM[idxM][0] += listM[idxM-1][0]
    else:
        answer = max(answer, listM[idxM][1] - listN[idxN][1])
        idxM += 1
        idxN += 1    
        if idxN < len(listN):
            listN[idxN][0] += listN[idxN-1][0]
            listM[idxM][0] += listM[idxM-1][0]
print(answer)
    