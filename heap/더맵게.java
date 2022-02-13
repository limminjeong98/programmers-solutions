import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i: scoville) {
            pq.offer(i);
        }
        if (pq.peek() >= K) {
            return answer;
        }
        answer = 1;
        while (pq.size() >= 2){
            int food = pq.poll() + pq.poll() * 2;
            pq.offer(food);
            if (pq.peek() >= K) {
                return answer;
            }
            answer++;
        }
        return -1;
    }
}