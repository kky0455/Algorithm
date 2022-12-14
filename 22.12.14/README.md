# 귤 고르기

## 1. 귤이 최대한 균등한 무게로 구성되게 k개의 수량을 맞추는 문제
## 2. 주어진 리스트를 탐색하여 크기별 수량을 Map에 저장
## 3. 정렬 후 k가 0이하로 떨어지는 순간까지 리스트를 탐색하여 카운트

```java
for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
```

- 주어진 리스트를 탐색하며 key에 따른 value값을 판단
- 존재하는 key면 해당 값을 없다면 0을 기본값으로하여 +1

```java
List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
```

- Map을 정렬하기위해 List형태로 변환

```java
entryList.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
```

- 변환한 List의 각 객체 value값을 비교하여 정렬 진행


## Map.Entry
 
 - Map에 Key를 가져오고 해당 value를 get함수로 가져오는 2단계의 작업을 하나의 과정으로 줄여줌
 
