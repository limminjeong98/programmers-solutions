import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12936

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        long[] factorial = new long[n];
        factorial[0] = 1l;
        
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // 0 based index로 변환
        k--;
        
        // 각 자리에 대한 숫자를 결정
        for (int i = 0; i < n; i++) {
            // 현재 자리에서 그룹 인덱스를 계산
            int index = (int) (k / factorial[n - 1 - i]);
            // 해당 그룹의 숫자를 결과에 추가
            answer[i] = numbers.get(index);
            // 사용한 숫자를 리스트에서 제거
            numbers.remove(index);
            // k 값 갱신
            k %= factorial[n - 1 - i];
        }
        
        return answer;
    }
}
