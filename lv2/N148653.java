
// 마법의 엘리베이터
// https://school.programmers.co.kr/learn/courses/30/lessons/148653

class Solution {
    // 최적 부분 구조의 문제이기 때문에 그리디로 풀기
    // BFS (완전탐색)로 풀기에는 입력이 너무 크다
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            // 현재 자릿수
            int currentDigit = storey % 10;
            // 다음 자릿수
            int nextDigit = (storey / 10) % 10;
            
            if (currentDigit > 5) {
                // 올림 (+1)
                answer += 10 - currentDigit;
                storey += 10;
            } else if (currentDigit == 5 && nextDigit >= 5) {
                // 현재 자릿수가 5인데 그 다음 자릿수도 5이상이면 올림
                answer += 5;
                // 다음 자릿수에 캐리 더함
                storey += 10;
            } else {
                // 내림 (-1)
                answer += currentDigit;
            }
            
            // 다음 자릿수로 이동
            storey /= 10;
        }
        return answer;
    }
}
