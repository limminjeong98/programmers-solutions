// https://school.programmers.co.kr/learn/courses/30/lessons/12971

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
            
        int n = sticker.length;
        if (n == 1) return sticker[0];
        if (n == 2) return Math.max(sticker[0], sticker[1]);

        int[][] dp = new int[2][n];
        
        // dp[0]은 첫번째 스티커를 떼는 경우
        dp[0][0] = sticker[0];
        dp[0][1] = Math.max(sticker[0], sticker[1]);
        
        for (int i = 2; i < n - 1; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + sticker[i]);
        }
        
        // dp[1]은 첫번째 스티커를 떼지 않는 경우
        dp[1][0] = 0;
        dp[1][1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + sticker[i]);
        }

        return Math.max(dp[0][n - 2], dp[1][n - 1]);
    }
}
