import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12981

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> visited = new HashSet<>();
        
        int length = words.length;
        int turn = length / n;
        if (length % n > 0) turn += 1;
        
        for (int i = 0; i < turn; i++) {
            for (int p = 0; p < n; p++) {
                int idx = i * n + p;
                if (idx >= length) break;
                String word = words[idx];
                if (word.length() == 1 || visited.contains(word)) {
                    return new int[] { p + 1, i + 1 };
                }
                if (idx > 0 && words[idx - 1].charAt(words[idx - 1].length() - 1) != words[idx].charAt(0)) {
                    return new int[] { p + 1, i + 1 };
                }
                visited.add(word);
            }
        }


        return new int[] { 0, 0 };
    }
}
