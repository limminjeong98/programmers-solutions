import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] arr = str.split("0");
        for (String s : arr) {
            if (s.equals("")) continue;
            // n이 최대 1,000,000인 경우 3진수로 변환했을 때 int 범위 벗어남
            if (isPrime(Long.parseLong(s))) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num == 1) return false;
        if (num == 2 || num == 3) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
