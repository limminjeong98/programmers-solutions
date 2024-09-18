import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hashMap = new HashMap<>();
        for (String[] cloth: clothes) {
            String clothType = cloth[1];
            hashMap.put(clothType, hashMap.getOrDefault(clothType, 0) + 1);
        }
        
        // for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
        //     answer *= (entry.getValue() + 1);
        // }
        for (int value : hashMap.values()) {
            // 해당 종류의 의상을 착용하지 않는 케이스 + 1
            answer *= (value + 1);
        }
        // 모든 의상을 착용하지 않는 케이스 제거
        return answer - 1;
    }
}
