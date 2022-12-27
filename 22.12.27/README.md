# 다리를 지나는 트럭

1. 주어진 트럭들이 다리를 모두 건너는데 걸리는 시간을 확인하는 문제
2. 큐를 생성하여 큐가 비어있는지 아닌지를 통해 문제를 풀이


```java
if (queue.isEmpty()) {
    queue.add(truck_weight);
    sumW += truck_weight;
    answer++;
    break;
}
```
- 비어있는 경우는 트럭을 큐에 추가시키고 시간 카운트를 증가

```java
if (queue.size() == bridge_length) {
    sumW -= queue.poll();
} else {
    if (sumW + truck_weight <= weight) {
        queue.add(truck_weight);
        sumW += truck_weight;
        answer++;
        break;
    } else {
        queue.add(0);
        answer++;
    }
}
```
- 비어있지 않은 경우는 다리가 꽉 찼을 때와 아닐 때를 구분
- 다리가 꽉 찬 경우 맨 앞 트럭을 빼고 무게합에서 빼기
- 아닌 경우는 다리가 최대 무게를 초과했는지 확인하여 진행



