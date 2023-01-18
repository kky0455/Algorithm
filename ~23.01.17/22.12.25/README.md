# H-Index

1. 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상, 나머지가 h이하인 최대값 h를 구하는 문제
2. 주어진 논문 인용 횟수를 정렬하고 위치별 인덱스를 활용해 h의 최대를 구하자

```java
for (int i = 0; i < citations.length; i++) {
    int h = Math.min(citations[i], citations.length-i);

    if (h >= answer) {
        answer = Math.max(h, answer);
    } else {
        break;
    }
}
```
- 인덱스를 비교하여 해당 인덱스의 인용 수가 조건에 맞을 경우 answer와 비교해 정답을 정하기