import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538

class Solution {
    
    public static int MAX_NUMBER = 1_000_000;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[MAX_NUMBER + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        dp[x] = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            int count = dp[now] + 1;
            if (now == y) {
                if (dp[y] == -1 || dp[y] > count) {
                    dp[y] = count;
                }
            }
            
            if (now + n <= MAX_NUMBER) {
                if (dp[now + n] == -1 || dp[now + n] > count) {
                    q.add(now + n);
                    dp[now + n] = count;
                }
            }
            if (now * 2 <= MAX_NUMBER) {
                if (dp[now * 2] == -1 || dp[now * 2] > count) {
                    q.add(now * 2);
                    dp[now * 2] = count;
                }
            }
            if (now * 3 <= MAX_NUMBER) {
                if (dp[now * 3] == -1 || dp[now * 3] > count) {
                    q.add(now * 3);
                    dp[now * 3] = count;
                }
            }
        }
        return dp[y] == -1 ? -1 : dp[y];
    }
}
