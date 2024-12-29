import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12987

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxA = A.length - 1;
        int idxB = B.length - 1;
        
        while (idxA >= 0 && idxB >= 0) {
            if (B[idxB] > A[idxA]) {
                answer++;
                idxA--;
                idxB--;
            } else if (B[idxB] == A[idxA]) {
                idxA--;
                // B의 인덱스는 줄이면 안 된다.
                // idxB--;
            } else {
                idxA--;
            }
        }
            
        return answer;
    }
}
