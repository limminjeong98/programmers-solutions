import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131704

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int length = order.length;
        
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= length; i++) {
            queue.addLast(i);
        }
        
        Deque<Integer> subQueue = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            while (!subQueue.isEmpty() || !queue.isEmpty()) {
                // 보조 컨테이너 벨트에서 내릴 수 있는지 확인
                flag = false;
                if (!subQueue.isEmpty()) {
                    int box = subQueue.peekLast();
                    if (order[i] == box) {
                        subQueue.removeLast();
                        flag = true;
                    }   
                }
            
                if (flag) {
                    answer++;
                    break;
                }
                
                if (!queue.isEmpty()) {
                    int box = queue.removeFirst();
                    if (order[i] != box) {
                        subQueue.addLast(box);
                        continue;
                    } else {
                        answer++;
                        flag = true;
                        break;
                    }
                }
                
                if (!flag) break;
            }
            if (!flag) break;
        }
        
        return answer;
    }
}
