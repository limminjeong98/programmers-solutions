import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        int count = 0;
        int n = s.length();
        
        while (count < n) {
            if (stack.isEmpty()) {
                stack.addLast(s.charAt(count));
            } else {
                if (stack.peekLast().equals(s.charAt(count))) {
                    stack.removeLast();
                } else {
                    // 다르면 넣어줘야함!!
                    stack.addLast(s.charAt(count));
                }
            }
            count++;
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}
