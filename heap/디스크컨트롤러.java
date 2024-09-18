import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
         // 각 작업의 요청부터 종료까지 걸린 시간의 총합
        int answer = 0;
        int n = jobs.length;
        
        Queue<Integer> q = new PriorityQueue<>();
        
        // 현재 시간
        int current = 0;
        // 마지막으로 작업이 처리된 시간 (이전 작업 시작 시간)
        int previous = -1;
        int cnt = 0;
        
        while (cnt < n) {
            for (int[] job : jobs) {
                // 작업 요청 시간
                int start = job[0];
                // 작업 소요 시간
                int jobTime = job[1];
                if (previous < start && start <= current) {
                    // 요청부터 시작되기까지의 시간
                    answer += current - start;
                    q.offer(jobTime);
                }
            }
            if (q.size() > 0) {
                // 소요 시간이 가장 짧은 작업을 먼저 처리
                int jobTime = q.poll();
                // 남은 작업들은 먼저 처리되는 작업이 끝나기까지 대기
                // 가장 짧은 작업이 처리되는 시간 자체도 포함해야 하기 때문에
                // 남은 작업들의 개수 + 처리되는 작업(1)
                answer += (q.size() + 1) * jobTime;
                previous = current;
                current += jobTime;
                cnt += 1;
            } else {
                 // 작업이 없을 경우 시간만 1씩 증가
                current += 1;
            }
        }
        return answer / n;
    }
}
