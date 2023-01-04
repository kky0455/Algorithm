n = int(input())
answer = 0
lst = []
for i in range(n):
    lst.append(list(map(int, input().split())))
lst = sorted(lst, key=lambda a:a[0])
lst = sorted(lst, key=lambda a:a[1])
idx = 0

for i, j in lst:
    if i >= idx:
        answer += 1
        idx = j
print(answer)