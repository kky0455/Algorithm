# 신입사원

1. 서류심사와 면접심사를 통해 선발되는 사원의 수를 구하는 문제
2. 한 지원자가 다른 지원자보다 서류, 면접 심사의 결과가 다 낮다면 합격할 수 없다.

```python
    N = int(input())
    answer = 1
    score = [list(map(int, input().split())) for _ in range(N)]
    score = sorted(score, key=lambda a:a[0])
    rank = score[0][1]
```
- 심사결과를 받아 서류심가 기준으로 오름차순 정렬
- 1등인 선수는 떨어질 걱정 없음

```python
    for i in range(1, N):
        if score[i][1] < rank:
            rank = score[i][1]
            answer += 1
```
- rank변수에 1등의 면접심사 등수를 저장한다.
- 지원자 리스트를 순회하며 기존 등수보다 더 높은 등수를 만나면 갱신하여 기준점을 정해둔다. 