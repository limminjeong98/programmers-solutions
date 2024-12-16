class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(n, i, computers, visited);
            answer++;
        }
        
        return answer;
    }
    
    public void dfs(int n, int i, int[][] computers, boolean[] visited) {
        visited[i] = true;
        
        for (int j = 0; j < n; j++) {
            if (visited[j]) continue;
            if (computers[i][j] == 1) {
                dfs(n, j, computers, visited);
            }
        }
    }
}
