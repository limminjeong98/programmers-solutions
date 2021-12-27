import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;

        Queue q = new LinkedList();
        Queue s = new LinkedList();

        for (int i = 0; i < n; i++) {
            q.add(progresses[i]);
            s.add(speeds[i]);
        }

        while (!q.isEmpty()) {
            int cnt = 1;
            int tmp = 1;
            while (true) {
                if ((int) s.peek() * cnt + (int) q.peek() >= 100) {
                    q.poll();
                    s.poll();
                    break;
                }
                cnt++;
            }
            if (!q.isEmpty()) {
                while (!q.isEmpty() && (int) s.peek() * cnt + (int) q.peek() >= 100) {
                    q.poll();
                    s.poll();
                    tmp++;
                }
            }
            answer.add(tmp);
        }
        int length = answer.size();
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}