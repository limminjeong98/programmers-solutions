// https://school.programmers.co.kr/learn/courses/30/lessons/172928

class Solution {
    // 오른쪽 아래가 동북 방향
    // E W S N
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int width = park.length;
        int height = park[0].length();
        
        int startX = 0, startY = 0;
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < height; c++) {
                if (park[r].charAt(c) == 'S') {
                    startX = r; startY = c;
                    break;
                } 
            }
        }
        
        int n = routes.length;
        int x = startX, y = startY;
        
        for (int i = 0; i < n; i++) {
            String[] route = routes[i].split(" ");
            char direction = route[0].charAt(0);
            int distance = Integer.valueOf(route[1]);
            int idx = 0;
            
            switch (direction) {
                case 'E': idx = 0;
                    break;
                case 'W': idx = 1;
                    break;
                case 'S': idx = 2;
                    break;
                case 'N': idx = 3;
                    break;
            }
            
            int nx = x, ny = y;
            
            int d = 1;
            boolean flag = true;
            while (d <= distance) {
                nx += dx[idx];
                ny += dy[idx];
                
                if (nx < 0 || nx >= width || ny < 0 || ny >= height || park[nx].charAt(ny) == 'X') {
                    flag = false;
                    break;
                }
                d++;
            }
            
            if (!flag) continue;;
            x = nx; y = ny;
        }
        
        return new int[] { x, y };
    }
}
