import java.util.Arrays;
import java.util.stream.IntStream;
// import java.util.Comparator;

class Solution {
    public int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = IntStream.range(0, n).toArray();
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        // Arrays.sort(costs, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         Integer u = o1[2];
        //         Integer v = o2[2];
        //         return u.compareTo(v);
        //     }
        // });
        
        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];
            int c = cost[2];
            x = findParent(x);
            y = findParent(y);
            if (x != y) {
                answer += c;
                unionParent(x, y);
            }
        }
        return answer;
    }
    
    public int findParent(int v) {
        if (parent[v] != v) {
            return parent[v] = findParent(parent[v]);
        }
        return parent[v];
    }
    
    public void unionParent(int v, int u) {
        v = findParent(v);
        u = findParent(u);
        if (v > u) {
            parent[v] = u;
        } else {
            parent[u] = v;
        }
    }
}
