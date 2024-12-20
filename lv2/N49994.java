import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/49994

class Solution {
     // 상하좌우
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static String[] directions = { "U", "D", "L", "R" };

    public static int solution(String dirs) {
        int answer = 0;

        // 0 ~ 10, 0 ~ 10
        // int[][] maps = new int[11][11];
        Set<List<Integer>> visited = new HashSet<>();

        int x = 5;
        int y = 5;

        int i = 0;
        int length = dirs.length();

        while (i < length) {
            String direction = dirs.substring(i, i + 1);
            int k = 0;
            for (int d = 0; d < 4; d++) {
                if (directions[d].equals(direction)) {
                    k = d;
                    break;
                }
            }

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) {
                i++;
                continue;
            }
            
            // 경로는 2가지 경우가 존재
            // [x,y] -> [nx,ny] , [nx,ny] -> [x,y]
            List<Integer> directWay = List.of(x, y, nx, ny);
            List<Integer> reverseWay = List.of(nx, ny, x, y);

            // 확인은 한방향으로만 하면된다
            if (!visited.contains(directWay)) {
                answer++;
                // 양쪽 방향을 모두 방문한걸로 처리해줘야 한다
                visited.add(directWay);
                visited.add(reverseWay);
            }

            x = nx;
            y = ny;

            i++;
        }
        return answer;
    }
}
