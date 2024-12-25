import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12927

class Solution {
    public long solution(int n, int[] works) {
        
        long sum = 0L;
        for (int w : works) {
            sum += w;
        }
        if (sum <= n) return 0l;
        
        // 작업량이 가장 큰 작업부터 줄인다 (평균을 줄이기)
        // (작업량, 인덱스)
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        
        for (int i = 0; i < works.length; i++) {
            queue.add(new int[] { works[i], i });
        }
        
        int count = 0;
        while (count < n) {
            int[] now = queue.poll();
            if (now[0] == 1) {
                works[now[1]] = 0;
            } else {
                works[now[1]] = now[0] - 1;
                queue.add(new int[] { now[0] - 1, now[1] });
            }
            count++;
        }
        
        long answer = 0L;
        for (int i = 0; i < works.length; i++) {
            answer += Math.pow(works[i], 2);
        }
        
        return answer;
    }
    
    
}
