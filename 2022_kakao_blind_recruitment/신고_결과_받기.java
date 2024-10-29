import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int length = id_list.length;
        int[] answer = new int[length];
        Map<String, Integer> idMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            idMap.put(id_list[i], i);
        } 
        
        // 신고당한 유저, 해당 유저를 신고한 유저들
        Map<String, Set<String>> mail = new HashMap<>();
        int n = report.length;
        for (int i = 0; i < n; i++) {
            String[] ids = report[i].split(" ");
            String from = ids[0];
            String to = ids[1];
            mail.putIfAbsent(to, new HashSet<>());
            mail.get(to).add(from);    
        }
        
        // k번 이상 누적 신고된 유저는 정지 
        for (String key : mail.keySet()) {
            Set<String> ids = mail.get(key);
            if (ids.size() < k) continue;
            for (String id : ids) {
                Integer index = idMap.get(id);
                answer[index] += 1;
            }
        }
        
        return answer;
    }
}
