# 택배상자

- 메인 컨테이너와 서브 컨테이너를 활용해 order리스트 순서대로 쌓을 수 있는 상자수를 구하는 문제
- 서브 컨테이너의 경우 스택을 활용한 후입선출을 활용

```java
Stack<Integer> subContainer = new Stack<>();
```
- 자바의 경우 스택이 존재하여 활용 가능

```java
if (order[answer] != i) {
    subContainer.add(i);
    continue;
}

answer++;

while (subContainer.size() != 0 && order[answer] == subContainer.peek()) {
    subContainer.pop();
    answer++;
}
```

- 반복문을 돌며 상자가 순서에 맞는지 확인
- 맞지 않는 경우는 서브 컨테이너로 이동
- 순서에 맞는 상자를 발견했을 경우 서브컨테이너에 마지막에 추가된 상자를 참고(peek())해 더 뺄 수 있는 상자가 존재하는지 확인