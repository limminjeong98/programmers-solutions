// https://school.programmers.co.kr/learn/courses/30/lessons/160585

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int n = board.length;

        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                } else if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }

        // X의 개수가 O의 개수보다 많은 경우
        if (oCount < xCount) return 0;
        
        // O의 개수가 X의 개수와 2개 이상 차이나는 경우 (최대 1개까지만 많을 수 있다)
        if (oCount > xCount + 1) return 0;

        // O가 이겼는데 X와의 차이가 1개가 아닌 경우 (O가 이긴 상황에서 바로 승부 종료되어야함)
        if (isWin(board, n, "OOO") && (oCount - xCount) != 1) return 0;

        // X가 이겼는데 O가 3개가 아닌 경우 (O가 선공)
        if (isWin(board, n, "XXX") && (oCount != xCount)) return 0;

        return 1;
    }

    public boolean isWin(String[] board, int length, String targetString) {
        boolean possible = false;

        StringBuilder sb;
        // 행과 열을 기준으로 확인
        for (int i = 0; i < length; i++) {
            sb = new StringBuilder();
            // 행
            if (board[i].equals(targetString)) {
                return true;
            }
            // 열
            for (int j = 0; j < length; j++) {
                sb.append(board[j].charAt(i));
            }
            if (targetString.equals(sb.toString())) {
                return true;
            }
        }

        // 왼쪽위 -> 오른쪽아래 대각선 확인
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(board[i].charAt(i));
        }
        if (targetString.equals(sb.toString())) {
            return true;
        }

        // 오른쪽위 -> 왼쪽아래 대각선 확인
        sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(board[i].charAt(length - 1 - i));
        }
        if (targetString.equals(sb.toString())) {
            return true;
        }

        return false;
    }
    
    
    
}
