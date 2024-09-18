import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        
        for (String operation : operations) {
            String[] ops = operation.split(" ");
            if (ops[0].equals("I")) {
                minHeap.offer(Integer.parseInt(ops[1]));
                maxHeap.offer(Integer.parseInt(ops[1]));
            } else {
                // 비어있는 큐에서 데이터를 삭제하라는 연산은 무시
                if (minHeap.isEmpty()) continue;
                if (ops[1].equals("1")) {
                    // 최대힙에서 삭제하고, 최소힙에서도 제거
                    minHeap.remove(maxHeap.poll());
                } else {
                    // 최소힙에서 삭제하고, 최대힙에서도 제거
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if (minHeap.isEmpty()) return new int[] { 0, 0 };
        return new int[] { maxHeap.poll(), minHeap.poll() };
    }
}
