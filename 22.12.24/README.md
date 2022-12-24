# 더 맵게

1. 우선순위큐를 활용한 문제
2. 원하는 스코빌 지수인 K보다 작은 음식들을 규칙에 맞게 섞어 K이상인 음식을 만들기

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

for (int sco : scoville) {
    priorityQueue.offer(sco);
}
```

- 우선순위 큐를 생성하고 주어진 음식들의 스코빌 지수를 큐에 저장
- 우선순위가 낮은 숫자로 정렬, ()안에 Collection.reverseOrder()를 넣으면 반대로 정렬

```java
while (priorityQueue.peek() < K) {
    if (priorityQueue.size() == 1) {
        return -1;
    }
    int food1 = priorityQueue.poll();
    int food2 = priorityQueue.poll();

    int food3 = food1 + (food2 * 2);

    priorityQueue.offer(food3);
    answer++;
}    
```

- peek() : 큐의 첫번째 값 확인
- poll() : 큐의 첫번째 값 반환
- offer() : 큐에 값 추가