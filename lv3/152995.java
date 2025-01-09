import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/152995

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int length = scores.length;
        
        // 0번 인덱스 완호의 점수
        int score1 = scores[0][0];
        int score2 = scores[0][1];
        
        // 인센티브를 받지 못하는 사원을 찾기
        // (근무태도점수 내림차순, 동료평가점수 오름차순) 정렬
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        
        // 근무태도점수는 내림차순이므로 동료평가점수만 확인하면 된다
        int maxScore = scores[0][1];
        
        for (int i = 1; i < length; i++) {
            // 인센티브를 받지 못하는 경우
            // 근무태도점수도 낮고, 동료평가점수도 낮은 사원
            if (scores[i][1] < maxScore) {
                // 완호 점수인 경우
                if (scores[i][0] == score1 && scores[i][1] == score2) {
                    return -1;
                }
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                // 다음 동료평가점수
                maxScore = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        answer = 1;
        for (int i = 0; i < length; i++) {
            if (scores[i][0] + scores[i][1] > score1 + score2) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
