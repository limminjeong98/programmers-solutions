import java.util.*;
import java.util.stream.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540

class Solution {
    // 상하좌우
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X') continue;
                if (visited[i][j]) continue;
                int size = bfs(maps, visited, i, j, n, m);
                answer.add(size);
            }
        }
        
        Collections.sort(answer);
        
        return answer.isEmpty() ? new int[] { -1 } : answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int bfs(String[] maps, boolean[][] visited, int x, int y, int n, int m) {
        int answer = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { x, y });
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0], col = position[1];
            if (visited[row][col]) continue;
            visited[row][col] = true;
            answer += Integer.valueOf(String.valueOf(maps[row].charAt(col)));
            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i], ny = col + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx].charAt(ny) == 'X') continue;
                if (visited[nx][ny]) continue;
                queue.add(new int[] { nx, ny });
            }
        }
        return answer;
    }
}
