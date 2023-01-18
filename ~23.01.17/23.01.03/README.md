# 상자 넣기

1. 상자 사이즈가 주어진다.
2. 작은 상자를 큰상자 안으로 넣을 때 얼마나 합쳐지는지 구하는 문제

```python
DP = [1] * n

for i in range(1, n):
    maxV = 0
    for j in range(0, i):
        if DP[j] > maxV and boxes[j] < boxes[i]:
            maxV = DP[j]
    DP[i] += maxV
```
- 각 인덱스에서 합쳐질 수 있는 상자의 최대를 기록할 배열 생성
- 2번째 상자부터 진행하며 이전 상자들 중 합쳐질 때 최대가 되는 값을 합치며 진행
- 리스트에서 가장 큰 값을 출력한다.