class Solution {
    public static int answer = 0;
    public static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n, i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int n, int cur, int[][] computers, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (computers[cur][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(n, i, computers, visited);
            }
        }
    }
}