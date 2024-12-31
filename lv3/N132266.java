import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/132266

class Solution {
    
    // 2차원 배열로 풀면 메모리 초과 -> 간선 리스트로 풀어야 함
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int target = sources.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
//         boolean[][] map = new boolean[n][n];
//         for (int i = 0; i < n; i++) {
//             map[i][i] = true;
//         }
        
//         for (int[] road : roads) {
//             map[road[0] - 1][road[1] - 1] = true;
//             map[road[1] - 1][road[0] - 1] = true;
//         }
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            edges.get(road[0] - 1).add(road[1] - 1);
            edges.get(road[1] - 1).add(road[0] - 1);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // 거리, 노드번호
        queue.offer(new int[] { 0, destination - 1 });
        
        int count = 0;
        while (!queue.isEmpty() && count < target) {
            int[] current = queue.poll();
            if (answer[current[1]] != -1) continue;
            answer[current[1]] = current[0];
            // if (targetSet.contains(current[1])) count++;
            if (count == target) break;
            
            List<Integer> arr = edges.get(current[1]);
           //  for (int i = 0; i < n; i++) {
                // if (map[current[1]][i]) {
            for (int i : arr) {
                if (answer[i] != -1) continue;
                queue.offer(new int[] { current[0] + 1, i });
                // }
            }
        }
        
        int[] distances = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            distances[i] = answer[sources[i] - 1];
        }
        
        return distances;
    }
}
