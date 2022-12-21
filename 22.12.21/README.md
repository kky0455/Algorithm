# 괄호 회전하기

1. 맨 앞에 있는 괄호를 맨 뒤로 이동시키며 해당 괄호 문자열이 올바른지 판단하는 문제
2. 스택을 활용해 여는 괄호는 스택에 저장하고 닫는 괄호면 스택에 있는 괄호를 꺼내 비교하여 판단

```java
for (int i = 0; i < s.length(); i++) {
    if (check(s)) {
        answer++;
    }
    s = s.substring(1, s.length()) + s.substring(0, 1);
}
```
- 문자열을 회전시키기 위해 substring 사용

```java
Stack<Character> stack = new Stack<>();
for (int i = 0; i<s.length(); i++) {
    if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        stack.add(s.charAt(i));
    } else {
        if (!stack.isEmpty()) {
            char o = stack.pop();
            char e = s.charAt(i);
            if (o == '(' && e == ')') continue;
            else if (o == '{' && e == '}') continue;
            else if (o == '[' && e == ']') continue;
            else return false;
        } else return false;
    }
}
if (!stack.isEmpty()) return false;
return true;
```

- 괄호에 따라 스택에 추가할지, 스택에서 꺼내 비교할지 판단