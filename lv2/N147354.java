import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/147354

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int row = data.length;
        int column = data[0].length;
        
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] != o2[col - 1]) return o1[col - 1] - o2[col -1];
            else return o2[0] - o1[0];
        });
        
        int result = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum += data[i][j] % (i + 1);
            }
            result ^= sum;
        }
        
        return result;
    }
}
