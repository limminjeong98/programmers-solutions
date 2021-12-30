import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> possibleRoutes;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];
        possibleRoutes = new ArrayList<>();
        dfs(0, "ICN", "ICN", tickets, n);
        Collections.sort(possibleRoutes);
        String[] answer = possibleRoutes.get(0).split(" ");
        return answer;
    }

    public void dfs(int cnt, String start, String currentRoutes, String[][] tickets, int n) {
        if (cnt == n) {
            possibleRoutes.add(currentRoutes);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], currentRoutes + " " + tickets[i][1], tickets, n);
                visited[i] = false;
            }
        }
    }
}