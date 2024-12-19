import java.util.*;
import java.util.stream.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // Set<Integer> toppingSet = Arrays.stream(topping).boxed().collect(Collectors.toSet());
        // int size = toppingSet.size();
        
        int length = topping.length;
        
        Map<Integer, Integer> toppingCount = new HashMap<>();
        
        int count = 0;

        // 토핑 종류별 개수
        Map<Integer, Integer> allCount = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int id = topping[i];
            allCount.put(id, allCount.getOrDefault(id, 0) + 1);
        }
        // 토핑 종류 수
        int size = allCount.keySet().size();
        
        for (int i = 0; i < length; i++) {
            int id = topping[i];
            if (toppingCount.containsKey(id)) {
                toppingCount.put(id, toppingCount.get(id) + 1);
            } else {
                count += 1;
                toppingCount.put(id, 1);
            }

            // 왼쪽으로 토핑을 하나씩 이동시키면서 기존에 갖고 있던 토핑의 수를 줄인다
            int left = allCount.get(id);
            if (left == 1) {
                allCount.remove(id);
                size--;
            } else {
                allCount.put(id, left - 1);
            }
            
            if (count == size) answer++;
            if (count > size) break;
        }
        
        return answer;
    }
}
