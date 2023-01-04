# 회의실 배정

1. N개의 회의 시작시간과 종료시간이 주어질 때 최대 사용할 수 있는 회의의 수를 구하는 문제
2. 동일 시간에 시작/종료되는 회의는 그 시간에 다른 회의가 또 시작될 수 있다.

```python
lst = []
for i in range(n):
    lst.append(list(map(int, input().split())))
lst = sorted(lst, key=lambda a:a[0])
lst = sorted(lst, key=lambda a:a[1])
```
- 회의의 시작시간과 종료시간이 들어있는 리스트를 저장
- 리스트를 시작시간을 기준으로 정렬 후 종료시간으로 한번 더 정렬

```python
for i, j in lst:
    if i >= idx:
        answer += 1
        idx = j
```
- 리스트를 순회하며 idx에 종료시간을 저장
- 종료시간보다 크거나 같은 시작시간이 온다면 정답 카운트를 올리고 종료시간 변경