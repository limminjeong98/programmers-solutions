import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993

class Solution {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int m = maps.length;
        int n = maps[0].length();
        
        int sx = 0, sy = 0;
        int ex = 0, ey = 0;
        int lx = 0, ly = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
        // (sx, sy) -> (lx, ly)
        int startToLever = bfs(maps, m, n, sx, sy, lx, ly);
        if (startToLever == -1) return -1;
        
        // (lx, ly) -> (ex, ey)
        int leverToEnd = bfs(maps, m, n, lx, ly, ex, ey);
        if (leverToEnd == -1) return -1;
        
        return startToLever + leverToEnd;
    }
    
    public int bfs(String[] maps, int m, int n, int sx, int sy, int tx, int ty) {
        boolean[][] visited = new boolean[m][n];
        int minimumDistance = Integer.MAX_VALUE;
        
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] { 0, sx, sy });
        visited[sx][sy] = true;
        while (q.size() > 0) {
            int[] now = q.poll();
            int dist = now[0], x = now[1], y = now[2];
            if (x == tx && y == ty) {
                minimumDistance = dist;
                break;
            }
            // visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (maps[nx].charAt(ny) == 'X') continue;
                if (visited[nx][ny]) continue;
                // visited 방문 처리를 큐에 넣기 전에 해줘야 시간초과가 안난다
                visited[nx][ny] = true;
                q.offer(new int[] { dist + 1, nx, ny });
            }
        }
        
        return minimumDistance == Integer.MAX_VALUE ? -1 : minimumDistance;
    }
            
        
}
