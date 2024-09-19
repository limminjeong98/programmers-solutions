import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
// import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        int n = progresses.length;
        
        // List<Integer> p = Arrays.stream(progresses).boxed().collect(Collectors.toList());
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            p.offer(progresses[i]);
            s.offer(speeds[i]);
        }
        
        while (!p.isEmpty()) {
            // 이번 작업이 배포되기까지 기간
            int day = 1;
            // 이번 작업에서 배포되는 기능의 개수
            int count = 1;
            while (true) {
                if ((p.peek() + s.peek() * day) >= 100) {
                    p.poll();
                    s.poll();
                    break;
                }
                day++;
            }
            
            while (!p.isEmpty() && (p.peek() + s.peek() * day) >= 100) {
                p.poll();
                s.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
