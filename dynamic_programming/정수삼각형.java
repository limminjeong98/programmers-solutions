import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        // int answer = 0;
        int n = triangle.length;
        
        int[][] sum = new int[n][n];
        sum[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int left = 0;
                int right = 0;
                // 맨 왼쪽 칸이 아니면 왼쪽 위 대각선 방향에서 이동 가능
                if (j != 0) {
                    left = sum[i - 1][j - 1];
                }
                // 맨 오른쪽 칸이 아니면 오른쪽 위 대각선 방향에서 이동 가능
                if (j != i) {
                    right = sum[i - 1][j];
                }
                // 원래 삼각형의 값과 두 대각선 경로 중 큰 값의 합으로 경로를 업데이트
                sum[i][j] = triangle[i][j] + Math.max(left, right);
            }
        }
        
        // Optional<Int>
        return Arrays.stream(sum[n - 1]).max().getAsInt();
    }
}
