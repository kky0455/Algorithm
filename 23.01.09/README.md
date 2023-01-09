# 숫자카드 2

1. N이 주어지고 N개의 카드 리스트가 주어진다.
2. M이 주어지고 N개의 카드 중 M의 카드가 얼마나 있는지 구하는 문제

```java
for (int i = 0; i < N; i++) {
    arr[i] = Integer.parseInt(st.nextToken());
}

Arrays.sort(arr);
```
- N개의 수를 정렬

```java
for (int i = 0; i < M; i++) {
    int num = Integer.parseInt(st.nextToken());

    sb.append(numOver(arr, num) - findNum(arr, num)).append(' ');
}

private static int findNum(int[] arr, int num) {
    int l = 0;
    int r = arr.length;

    while (l < r) {
        int mid = (l+r)/2;

        if (num <= arr[mid]) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}

private static int numOver(int[] arr, int num) {
    int l =0;
    int r = arr.length;

    while (l <r) {
        int mid = (l+r)/2;

        if (num < arr[mid]) {
            r = mid;
        }else {
            l = mid+1;
        }
    }
    return l;
}
```
- 이진탐색을 통해 해당 숫자의 시작 인덱스, 해당 숫자를 초과하는 인덱스를 찾는다.
- 두 숫자의 차이가 곧 숫자의 개수