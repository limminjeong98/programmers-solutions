import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12914

class Solution {
    public long solution(int n) {
        if (n <= 1) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // long overflow
            dp[i] = dp[i - 2] % 1234567 + dp[i - 1] % 1234567;
        }
        return dp[n] % 1234567;
    }
}
