import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    // 상하좌우
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        if (maps[n - 1][m - 1] == 0) return -1;
            
        visited = new boolean[n][m];
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 1, 0, 0 });
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int distance = current[0];
            int x = current[1];
            int y = current[2];
            
            // 이미 방문한 칸이면 재방문하지 않음
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            for (int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                // 벽이면 더 이상 진행 불가
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                // 처음 방문하거나, 이미 큐에 넣은 경로보다 짧은 경로일때만 큐에 넣는다
                if (maps[nx][ny] == 1 || maps[nx][ny] > distance + 1) {
                    pq.offer(new int[] { distance + 1, nx, ny });
                    maps[nx][ny] = distance + 1;
                }
                
            }
        }
        if (!visited[n - 1][m - 1]) return -1;
        return maps[n - 1][m - 1];
    }
}
