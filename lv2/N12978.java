import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        boolean[] visited = new boolean[N];
        int[][] graph = new int[N][N];
        
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph[a - 1][b - 1] = Math.min(graph[a - 1][b - 1], c);
            graph[b - 1][a - 1] = graph[a - 1][b - 1];
        }
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        // (거리, 노드)
        queue.add(new int[] { 0, 0 });
        visited[0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[1], dist = current[0];
            if (dist > K) continue;
            // System.out.printf("node = %d, current = %d\n", node, dist);
            if (distance[node] <= dist) continue;
            distance[node] = dist;
            
            for (int i = 0; i < N; i++) {
                if (graph[node][i] != Integer.MAX_VALUE && distance[i] > dist + graph[node][i]) {
                    queue.add(new int[] { dist + graph[node][i], i });
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (distance[i] <= K) answer++;
        }
        
        return answer;
    }
}
