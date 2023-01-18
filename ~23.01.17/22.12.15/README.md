# 숫자 카드 나누기

1. 배열을 정렬하여 가장 작은 수의 약수를 내림차순으로 저장
2. 배열을 탐색하며 속해있는 배열을 모두 나눌 수 있으며 다른 배열은 모두 나눌 수 없는 경우 answer와 비교

```java
for (int i =2; i*i <= arr1[0]; i++) {
            if (arr1[0] % i == 0) {
                divisors.add(i);
                divisors.add(arr1[0]/i);
            }
        }
divisors.add(arr1[0]);

        Collections.sort(divisors, Collections.reverseOrder());
```
- 약수를 찾는 방식을 간소화하여 메모리 초과 방지
- 약수를 리스트에 담은 후 내림차순 정렬