// 멀쩡한 사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/62048

class Solution {
    public long solution(int w, int h) {
        // overflow 주의
        long answer = (long)w * h;
        // 최대공약수
        long gcd;
        if (w >= h) {
            gcd = greatestCommonDivisor(h, w);
        } else {
            gcd = greatestCommonDivisor(w, h);
        }
        // overflow 주의
        answer -= w;
        answer -= h;
        answer += gcd;
        return answer;
    }
    
    public long greatestCommonDivisor(long a, long b) {
        if (b % a == 0) return a;
        return greatestCommonDivisor(b % a, a);
    }
}
