import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946

class Solution {
    public int[][] solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result);
        return result.stream().toArray(int[][]::new);
    }
    
    public void hanoi(int n, int from, int to, int via, List<int[]> result) {
        if (n == 1) {
            // 원판 하나를 목적지로 이동
            result.add(new int[] { from, to });
            return;
        }
        // 위에서부터 n - 1 개를 from -> via로 이동
        hanoi(n - 1, from, via, to, result);
        // 맨 밑의 가장 큰 원판 1개를 from -> to로 이동
        result.add(new int[] { from, to });
        // n - 1개의 원판을 다시 via -> to로 이동
        hanoi(n - 1, via, to, from, result);
    }
}
