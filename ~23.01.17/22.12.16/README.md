# 점 찍기

1. 피타고라스 원리를 이용한 문제
2. d가 최대일 때 y좌표의 최대값을 구한 후, k로 나눠 d이하의 좌표 개수를 구할 수 있음

```java
for (int i = 0; i <= d; i += k) {
            long X = (long) i*i;
            long D = (long) d*d;
            int Y = (int)Math.sqrt(D - X);
            answer += (Y/k)+1;
        }
```

- 제곱을 할 때, int값의 범위를 넘어서는 경우가 발생하여 정답에 실패하는 상황 발생
- 이를 생각하고 데이터 타입을 정해 문제를 풀자