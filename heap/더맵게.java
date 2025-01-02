import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        
        while (queue.size() > 0) {
            int first = queue.poll();
            if (first >= K) return answer;
            if (queue.isEmpty()) {
                answer = -1;
                break;
            }
            int second = queue.poll();
            queue.offer(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}
