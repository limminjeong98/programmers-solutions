import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12949

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        
        int row2 = arr2.length;
        int col2 = arr2[0].length;
        
        int[][] answer = new int[row1][col2];
        
        for (int r = 0; r < row1; r++) {
            for (int c = 0; c < col2; c++) {
                for (int t = 0; t < col1; t++) { // col1 == row2
                    answer[r][c] += arr1[r][t] * arr2[t][c];
                }
                
            }
        }
        return answer;
    }
}
