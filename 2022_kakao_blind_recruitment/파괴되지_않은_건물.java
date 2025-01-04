// https://school.programmers.co.kr/learn/courses/30/lessons/92344

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] matrix = new int[n + 1][m + 1];
        
        for (int[] sk : skill) {
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];
            // 공격
            if (type == 1) {
                type = -1;
            } else {
                // 회복
                type = 1;
            }
            matrix[r1][c1] += type * degree;
            matrix[r1][c2 + 1] += type * degree * -1;
            matrix[r2 + 1][c1] += type * degree * -1;
            matrix[r2 + 1][c2 + 1] += type * degree;
        }
        
        // 각 행별로 누적합 계산 (오른쪽으로 밀면서)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        // 각 컬럼별로 누적합 계산 (아래로 밀면서)
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] + board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
