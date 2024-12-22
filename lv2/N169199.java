import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199

class Solution {
    public static int[] dx = { -1, 1, 0, 0};
    public static int[] dy = { 0, 0, -1, 1};
    
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        
        int row = board.length;
        int column = board[0].length();
        
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i; startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    endX = i; endY = j;
                }
            } 
        }
        
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[2] - o2[2];
        });
        // (현재까지 이동거리, 현재 x, 현재 y)
        queue.add(new int[] { 0, startX, startY });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int dist = current[0], x = current[1], y = current[2];
            if (board[x].charAt(y) == 'G') {
                answer = Math.min(answer, dist);
                continue;
            } else if (board[x].charAt(y) == 'V') {
                // 이전에 방문한 경우
                continue;
            }
            // '.' -> 'V' 방문 처리
            board[x] = board[x].substring(0, y) + 'V' + board[x].substring(y + 1);
            
            for (int d = 0; d < 4; d++) {
                int cx = x, cy = y;
                // 현재 방향으로 이동 가능할때까지 계속 큐에 넣고, 이동
                while (true) {
                    int nx = cx + dx[d], ny = cy + dy[d];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= column) break;
                    if (board[nx].charAt(ny) == 'D') break; // 장애물인 경우
                    cx = nx;
                    cy = ny;
                }
                if (board[cx].charAt(cy) == 'V') continue; // 이전에 방문한 경우
                queue.add(new int[] { dist + 1, cx, cy });
            }   
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
