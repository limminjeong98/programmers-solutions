import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502

class Solution {
    public int solution(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(s);
        int answer = 0;
        for (int i = 0; i < length; i++) {
            String target = sb.substring(i, i + length);
            Deque<Character> stack = new ArrayDeque<>();

            int count = 0;
            while (count < length) {
                char ch = target.charAt(count);
                if (stack.isEmpty()) stack.addLast(ch);
                else {
                    Character c = stack.peekLast();
                    if (c == '[' && ch == ']') stack.removeLast();
                    else if (c == '{' && ch == '}') stack.removeLast();
                    else if (c == '(' && ch == ')') stack.removeLast();
                    else stack.addLast(ch); // 까먹지 말기..... 반드시 넣어줘야함..... 
                }
                count++;
            }
            if (stack.isEmpty()) answer++;
        }
        return answer;
    }
}
