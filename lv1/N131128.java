import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131128

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<Integer> arr = new ArrayList<>();
        
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            countMap.put(X.charAt(i), countMap.getOrDefault(X.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < Y.length(); i++) {
            if (countMap.containsKey(Y.charAt(i))) {
                arr.add(Integer.valueOf(String.valueOf(Y.charAt(i))));
                Integer leftCount = countMap.get(Y.charAt(i));
                if (leftCount == 1) {
                    countMap.remove(Y.charAt(i));
                } else {
                    countMap.put(Y.charAt(i), leftCount - 1);
                }
            }
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.size(); i++) {
            answer.append(arr.get(i));
        }
        
        if (answer.length() == 0) return "-1";
        // "000" -> "0"
        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}
