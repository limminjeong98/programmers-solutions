import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hashMap = new HashMap<>();
        for (String[] arr : clothes) {
            String itemType = arr[1];
            hashMap.put(itemType, hashMap.getOrDefault(itemType, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        return answer - 1;
    }
}