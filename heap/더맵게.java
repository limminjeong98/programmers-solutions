import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue pq = new PriorityQueue();
        for (int i : scoville) {
            pq.offer(i);
        }
        if ((int) pq.peek() >= K) {
            return answer;
        }
        answer = 1;
        while (pq.size() >= 2) {
            int food = (int) pq.poll() + (int) pq.poll() * 2;
            pq.offer(food);
            if ((int) pq.peek() >= K) {
                return answer;
            }
            answer++;
        }
        return -1;
    }
}