import java.lang.Math;

// https://school.programmers.co.kr/learn/courses/30/lessons/17682

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int score = 0;
        int prevScore = 0;
        int end = dartResult.length();
        int idx = 0;
        while (idx < end) {
            // 점수: 1 ~ 10점
            if (dartResult.substring(idx, idx + 2).equals("10")) {
                score = 10;
                idx++;
            } else {
                score = Integer.valueOf(dartResult.substring(idx, idx + 1));
                // score = Integer.valueOf(dartResult.charAt(idx)); -> ascii로 인식해서 에러
            }
            idx++;
            if (dartResult.charAt(idx) == 'D') {
                score = (int)Math.pow(score, 2);
            } else if (dartResult.charAt(idx) == 'T') {
                score = (int)Math.pow(score, 3);
            }
            idx++;
            if (idx >= end) {
                answer += score;
                break;
            }
            if (dartResult.charAt(idx) == '*') {
                answer += prevScore;
                answer += score * 2;
                prevScore = score * 2; // score * 2 + prevScore
                idx++;
            } else if (dartResult.charAt(idx) == '#') {
                answer -= score;
                prevScore = -1 * score;
                idx++;
            } else {
                answer += score;
                prevScore = score;
            }
        }
        return answer;
    }
}
