import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // weight count
        Map<Double, Long> map = new HashMap<>();
        for (int weight : weights) {
            // 같은 무게인 경우의 수
            answer += map.getOrDefault((double)weight, 0L);
            // (2, 3), (2, 4), (3, 2), (3, 4), (4, 2), (4, 3)
            answer += map.getOrDefault((double)weight * 2 / 3, 0L);
            answer += map.getOrDefault((double)weight * 2 / 4, 0L);
            answer += map.getOrDefault((double)weight * 3 / 2, 0L);
            answer += map.getOrDefault((double)weight * 3 / 4, 0L);
            answer += map.getOrDefault((double)weight * 4 / 2, 0L);
            answer += map.getOrDefault((double)weight * 4 / 3, 0L);
            
            // 현재 무게를 맵에 추가
            map.put((double)weight, map.getOrDefault((double)weight, 0L) + 1);
        }
        return answer;
    }
}
