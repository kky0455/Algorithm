# 구명보트

1. 무게제한이 있는 구명보트를 최대한 적게 사용해 모든 사람을 구출하는 문제
2. 그리디 알고리즘으로 사람들의 몸무게를 정렬한 후 구명보트의 무게 제한을 고려하여 문제를 푼다.

```java
List<Integer> lst = new ArrayList<>();
Arrays.sort(people);
for (int i = people.length-1; i >= 0; i--) {
    lst.add(people[i]);
}
Deque<Integer> deque = new ArrayDeque<>(lst);
```

- 리스트를 생성하여 사람들의 무게 정보를 기입하고 deque로 변경

```java
while (!deque.isEmpty()) {
    int sumV = deque.peekFirst() + deque.peekLast();
    if (sumV > limit) {
        deque.pollFirst();
        answer++;
    } else {
        deque.pollFirst();
        deque.pollLast();
        answer++;
    }
    if (!deque.isEmpty()) {
        if (deque.peekLast() > Math.ceil((double) limit/2.0)) {
            break;
        }
    }
}
```

- deque가 빌 때 까지 로직을 반복하며 답을 찾는 문제
- ceil은 입력 인자값보다 크거나 같은 가장 작은 정수 값을 double형으로 반환