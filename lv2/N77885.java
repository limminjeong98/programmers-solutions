import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/77885

class Solution {
    public long[] solution(long[] numbers) {
        int length = numbers.length;
        long[] answer = new long[length];
        
        for (int i = 0; i < length; i++) {
            long number = numbers[i];
            // 짝수인 경우
            if (number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                // 홀수인 경우
                long next = number + 1;
                long diff = number ^ next;
                // 비트 XOR 연산의 차이가 1이라면 
                if (diff < 2) {
                    answer[i] = next;
                } else {
                    // XOR 연산 차이나는 비트가 2개 이상이라면
                    // 가장 오른쪽에 위치한 1을 찾아 최소한으로 조정
                    // number: 7(0111), next: 8(1000)
                    // 8(1000) & -8(1000) / 2 = 8(1000) / 2 = 4(100)
                    // 7(0111) + 4(100) = 11(1011)
                    answer[i] = number + (next & -next) / 2;
                }
            }
        }
        return answer;
    }
}
