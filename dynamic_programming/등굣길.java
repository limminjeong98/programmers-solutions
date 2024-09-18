class Solution {
    static int N = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        for (int[] puddle : puddles) {
            // 물에 잠김 곳은 -1로 처리
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        map[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) continue;
                if (i > 0 && map[i - 1][j] > 0) {
                    map[i][j] += map[i - 1][j];
                    map[i][j] %= N;
                    // 2번 map[i][j] += map[i - 1][j] % N;
                    
                }
                if (j > 0 && map[i][j - 1] > 0) {
                    map[i][j] += map[i][j - 1];
                    map[i][j] %= N;
                    // 2번 map[i][j] += map[i][j - 1] % N;
                }
            }
        }
        return map[n - 1][m - 1];
        // 2번 return map[n - 1][m - 1] % N;
    }
}
