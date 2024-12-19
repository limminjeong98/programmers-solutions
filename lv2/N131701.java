import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131701

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        int[] arr = new int[length * 2];
        for (int i = 0; i < length; i++) {
            arr[i] = elements[i];
            arr[length + i] = elements[i];
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int start = 0; start < length; start++) {
            int sum = arr[start];
            if (!visited.contains(sum)) {
                visited.add(sum);
            }
            for (int end = start + 1; end < start + length; end++) {
                sum += arr[end];
                if (!visited.contains(sum)) {
                    visited.add(sum);
                }
            }
        }
        
        return visited.size();
    }
}
