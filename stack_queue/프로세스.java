import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        int n = priorities.length;
        
        // Queue 인터페이스는 LinkedList로 구현
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(priorities[i]);
        }
        
        while (!queue.isEmpty()) {
            int maxPriority = Collections.max(queue);
            // 해당 프로세스가 대기 큐에서 가장 우선 순위가 높은 프로세스라면 실행한다
            if (maxPriority == queue.peek()) {
                queue.poll();
                // 몇 번째로 실행되는지 확인하려는 프로세스였다면 그대로 종료
                if (location == 0) return answer;
                answer++;
            } else {
                // 대기 큐에 해당 프로세스보다 우선 순위가 높은 프로세스가 있다면 큐의 맨마지막으로 이동
                queue.offer(queue.poll());
            }
            location--;
            if (location < 0) {
                location = queue.size() - 1;
            }  
        }
        
        return answer;
    }
}
