# 롤케이크 자르기

1. 하나의 리스트는 종류만 파악할 수 있도록 HashSet사용
2. 다른 리스트는 수량과 종류를 파악할 수 있도록 HashMap사용
3. 자르는 기준점을 이동시키며 토핑의 종류가 같은 케이스를 답에 추가시켜준다.

```java
lst1.add(topping[0]);
for (int i = 1; i < lenTopping; i++) {
    lst2.put(topping[i], lst2.getOrDefault(topping[i], 0)+1);
}
```

- 1번 리스트는 처음 토핑정보를 저장
- 2번 리스트는 처음을 제외한 모든 토핑 종류를 기록

```java
for (int i = 1; i < lenTopping; i++) {
    lst1.add(topping[i]);
    lst2.put(topping[i], lst2.get(topping[i])-1);
    if (lst2.get(topping[i]) == 0) {
        lst2.remove(topping[i]);
    }
    if (lst1.size() == lst2.size()) {
        answer++;
    }
}
```

- 자르는 기준점을 순서대로 옮기며 토핑이 같아지는 상황이 있을 때 정답 카운트 1상승