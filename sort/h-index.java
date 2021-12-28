import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        while (true) {
            int cnt = 0;
            for (int i : citations) {
                if (i >= answer) {
                    cnt++;
                }
            }
            if (cnt < answer) {
                return answer - 1;
            }
            answer++;
        }
    }
}