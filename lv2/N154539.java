import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154539

class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 맨 뒤에 위치한 원소나 자신보다 큰 수가 없어서 스택에서 끝까지 pop되지 못한 경우
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()) {
                Integer index = stack.peek();
                if (numbers[index] < numbers[i]) {
                    answer[index] = numbers[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            // 현재 숫자의 뒷 큰수도 확인해야 함
            stack.push(i);
        }
        
        return answer;
    }
}
