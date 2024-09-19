import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        int n = s.length();
        // Deque, ArrayDeque로 stack 구현할때 그대로 push, pop, peek 메서드 쓰면 된다!!
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                if (c == ')') return false;
                else stack.push(c);
            } else {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }  
            }      
        }

        return stack.isEmpty();
    }
}
