# 잃어버린 괄호

1. 주어진 식에 괄호를 적절히 만들어 값을 최소로 만들기

```java
String[] arr = br.readLine().split("-");
int answer = 0;
for (int i=0; i < arr.length; i++) {
    int sumV = 0;
    String[] cal = arr[i].split("\\+");

    for (int j = 0; j < cal.length; j++) {
        sumV += Integer.parseInt(cal[j]);
    }
    if (i == 0) {
        answer += sumV;
    }else {
        answer -= sumV;
    }
}
```
- 최대한 큰 수를 빼기 위해 '-'를 기준으로 식을 나눠서 덧셈부터 진행
- split의 경우 정규식을 받기 때문에 단순히 "+"를 하면 에러가 발생
- 온전히 사용하기 위해 이스케이프 처리를 진행(\\+)