import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public static int INF = Integer.MAX_VALUE;
    public static int[] dist;
    public static boolean[] visited;
    public static List<List<Integer>> graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        
        visited = new boolean[n];
        
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1);
        }
        
        dijkstra(n);
        
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            if (maxDistance < dist[i]) {
                maxDistance = dist[i];
                answer = 1;
            } else if (maxDistance == dist[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int n) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // [1번 노드까지의 거리, 해당 노드의 번호]
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int distance = now[0];
            int node = now[1];
            if (visited[node]) continue;
            visited[node] = true;
            for (int i : graph.get(node)) {
                if (visited[i]) continue;
                if (dist[i] > distance + 1) {
                    dist[i] = distance + 1;
                    pq.offer(new int[] { distance + 1, i });
                }  
            }
        }
    }
}
