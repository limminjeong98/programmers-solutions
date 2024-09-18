import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] scoville, int K) {

        Arrays.sort(scoville);
        if (scoville[0] >= K) return 0;
        
        // 이렇게하면 에러남
        // Queue<Integer> heap = new PriorityQueue<>(Arrays.asList(Arrays.stream(scoville).boxed().toArray()));
        Queue<Integer> heap = new PriorityQueue(Arrays.asList(Arrays.stream(scoville).boxed().toArray()));
        
        int answer = 0;
        
        while (heap.size() > 1) {
            answer++;
            int score = heap.poll() + heap.poll() * 2;
            heap.offer(score);
            if (heap.peek() >= K) return answer;
        }
        
        return -1;
    }
}
