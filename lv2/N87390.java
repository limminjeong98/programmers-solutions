import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/87390

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n + 1;
            long column = i % n + 1;
            answer[idx] = (int) Math.max(row, column);
            idx++;
        }
        return answer;
    }
}
