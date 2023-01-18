# 기타레슨

1. 주어진 M개의 블루레이에 N개의 강의를 최소한의 크기로 담는 문제
2. 이분탐색을 활용해 시간의 평균값을 통해 최소로 가능한 블루레이 크기를 구하기
3. 최소와 최대값을 막 잡다가 고생한 문제

```python
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
```
- 최소값은 주어진 리스트의 가장 큰 값, 최대값은 리스트의 합으로 블루레이 크기의 범위를 정하기
- 리스트를 순회하며 시간을 계속 더하고 평균값을 넘는지 판단하여 로직을 수행한다.
