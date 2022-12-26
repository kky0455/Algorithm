# 올바른 괄호

1. 주어진 괄호 문자열이 올바른지 판단하는 문제
2. 스택을 생성해 여는 괄호인 경우 스택에 집어넣기
3. 닫는 괄호인 경우 스택을 확인하여 여는 괄호를 제거, 비어있으면 false 반환
4. 모든 괄호 문자열을 탐색한 후 스택에 남은 괄호가 있는지 확인하여 정답 판단

```java
for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == '(') {
        stack.push(s.charAt(i));
    }else {
        if (stack.isEmpty()) {
            return false;
        }
        stack.pop();
    }
}
```

- 주어진 문자열을 확인해 괄호 모양에 따라 판단