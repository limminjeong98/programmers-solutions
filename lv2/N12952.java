// https://school.programmers.co.kr/learn/courses/30/lessons/12952

class Solution {
    public int solution(int n) {
        int[] answer = new int[1];
        // idx번째 행에 위치한 퀸의 컬럼 좌표
        int[] columns = new int[n];
        dfs(columns, answer, 0, n);
        return answer[0];
    }
    
    public void dfs(int[] columns, int[] answer, int row, int n) {
        if (row == n) {
            answer[0] += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            columns[row] = i;
            // (row, i)에 퀸을 놓을 수 있는지 검사
            // 이전에 놓인 퀸들의 위치를 가지고 검사
            boolean flag = true;
            for (int r = 0; r < row; r++) {
                // 위의 행 중에서 같은 열에 위치한 퀸이 있는지
                if (columns[r] == columns[row]) {
                    flag = false;
                    break;
                }
                // 대각선
                if ((row - r) == Math.abs(columns[row] - columns[r])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                dfs(columns, answer, row + 1, n);
            }
        }
    }
}
