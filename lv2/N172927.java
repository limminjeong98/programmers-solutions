import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/172927

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[] answer = { Integer.MAX_VALUE };
        
        Map<String, Integer> counts = new HashMap<>();
        counts.put("diamond", picks[0]);
        counts.put("iron", picks[1]);
        counts.put("stone", picks[2]);
        
        int left = picks[0] + picks[1] + picks[2];
        
        int length = minerals.length;
        
        dfs(minerals, counts, answer, 0, 0, length, left);
        
        return answer[0];
    }
    
    public void dfs(String[] minerals, Map<String, Integer> counts, int[] answer, int total, int index, int length, int left) {
        // 다이아몬드
        if (counts.containsKey("diamond") && counts.get("diamond") > 0) {
            int idx = index;
            int cnt = 5;
            int sum = total;
            while (idx < length && cnt > 0) {
                sum += 1;
                idx++;
                cnt--;
            }
            if (idx == length || left == 1) {
                // 현재 곡괭이로 모든 광물을 다 캤거나 남은 곡괭이가 없는 경우
                answer[0] = Math.min(answer[0], sum);
            } else {
                counts.put("diamond", counts.get("diamond") - 1);
                dfs(minerals, counts, answer, sum, idx, length, left - 1);
                counts.put("diamond", counts.get("diamond") + 1);
            }
        }
        // 철
        if (counts.containsKey("iron") && counts.get("iron") > 0) {
            int idx = index;
            int cnt = 5;
            int sum = total;
            while (idx < length && cnt > 0) {
                if (minerals[idx].equals("diamond")) {
                    sum += 5;
                } else {
                    sum += 1;
                }
                idx++;
                cnt--;
            }
            if (idx == length || left == 1) {
                // 현재 곡괭이로 모든 광물을 다 캤거나 남은 곡괭이가 없는 경우
                answer[0] = Math.min(answer[0], sum);
            } else {
                counts.put("iron", counts.get("iron") - 1);
                dfs(minerals, counts, answer, sum, idx, length, left - 1);
                counts.put("iron", counts.get("iron") + 1);
            }
        }
        // 돌
        if (counts.containsKey("stone") && counts.get("stone") > 0) {
            int idx = index;
            int cnt = 5;
            int sum = total;
            while (idx < length && cnt > 0) {
                if (minerals[idx].equals("diamond")) {
                    sum += 25;
                } else if (minerals[idx].equals("iron")) {
                    sum += 5;
                } else {
                    sum += 1;
                } 
                idx++;
                cnt--;
            }
            if (idx == length || left == 1) {
                // 현재 곡괭이로 모든 광물을 다 캤거나 남은 곡괭이가 없는 경우
                answer[0] = Math.min(answer[0], sum);
            } else {
                counts.put("stone", counts.get("stone") - 1);
                dfs(minerals, counts, answer, sum, idx, length, left - 1);
                counts.put("stone", counts.get("stone") + 1);
            }
        }
        
        
    }
}
