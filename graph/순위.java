import java.util.Arrays;

class Solution {
    public static int[][] graph;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 0);
        }
        for (int[] result : results) {
            // A선수가 B선수에게 이겼다 => 1
            graph[result[0] - 1][result[1] - 1] = 1;
            // B선수가 A선수에게 졌다 => -1
            graph[result[1] - 1][result[0] - 1] = -1;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 이미 승부를 알고 있다면 업데이트 불필요
                    if (graph[i][j] != 0 && graph[j][i] != 0) continue;
                    // 다른 선수를 통해서 승부를 알 수 있는 경우 업데이트
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) {
                    tmp++;
                } 
            }
            if (tmp == n - 1) answer++;
        }
        return answer;
    }
}
