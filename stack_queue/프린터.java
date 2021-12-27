import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue q = new LinkedList();
        Queue pq = new PriorityQueue();
        int n = priorities.length;
        for (int i = 0; i < n; i++) {
            q.add(priorities[i]);
            pq.add(-priorities[i]);
        }
        while (!q.isEmpty()) {
            int cur = (int) q.poll();
            if (-(int) pq.peek() != cur) {
                q.add(cur);
            } else {
                answer++;
                pq.poll();
                if (0 == location) {
                    return answer;
                }
            }
            location--;
            if (location < 0) {
                location = q.size() - 1;
            }
        }
        return answer;
    }
}