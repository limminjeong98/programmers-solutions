import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int answer;

    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        int l = words[0].length();
        visited = new boolean[n];
        answer = 51;
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        bfs(n, l, 0, begin, target, words, visited);
        answer = (answer == 51 ? 0 : answer);
        return answer;
    }

    public void bfs(int n, int l, int cnt, String begin, String target, String[] words, boolean[] visited) {
        if (begin.equals(target)) {
            answer = (answer > cnt ? cnt : answer);
            return;
        }
        cnt++;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int tmp = 0;
            for (int j = 0; j < l; j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    tmp++;
                }
            }
            if (tmp == 1) {
                visited[i] = true;
                bfs(n, l, cnt, words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }
}