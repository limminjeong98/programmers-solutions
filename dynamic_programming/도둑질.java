class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        // 첫번째 집을 터는 대신 마지막 집을 털 수 없음
        dp1[0] = money[0];
        dp1[1] = money[0];
        // 첫번째 집을 털지 않는 대신 마지막 집을 털 수 있음
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(money[i] + dp1[i - 2], dp1[i - 1]);
            dp2[i] = Math.max(money[i] + dp2[i - 2], dp2[i - 1]);
        }
        dp1[n - 1] = Math.max(dp1[n - 2], dp1[n - 3]);
        dp2[n - 1] = Math.max(money[n - 1] + dp2[n - 3], dp2[n - 2]);
        
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
