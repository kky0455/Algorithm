import sys
input = sys.stdin.readline

w, h = map(int, input().split())
n = int(input())
lst = list()

for i in range(n+1):
  if i == n:
    dir, dis = map(int, input().split())
  else:
    lst.append(list(map(int, input().split())))

def check(direction, distance):
  if direction == 1:
    return distance
  elif direction == 2:
    return w + h + (w-distance)
  elif direction == 3:
    return w + h + w + (h-distance)
  else:
    return w + distance

sumV = 0
d1 = check(dir, dis)
for i in range(n):
    d2 = check(lst[i][0], lst[i][1])
    p1 = abs(d1 - d2)
    p2 = 2 * w + 2 * h - p1
    if p1 < p2:
        sumV += p1
    else:
        sumV += p2
print(sumV)