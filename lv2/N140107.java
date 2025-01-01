// https://school.programmers.co.kr/learn/courses/30/lessons/140107

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long dSquare = (long)Math.pow(d, 2.0);
        for (int i = 0; i <= d; i += k) {
            long currentSquare = (long)Math.pow(i, 2.0);
            int y = (int)Math.sqrt(dSquare - currentSquare);
            answer += y / k + 1;
        }
        return answer;
    }
}
