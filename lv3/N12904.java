// https://school.programmers.co.kr/learn/courses/30/lessons/12904

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n < 2) return n;
        int answer = 1;
        
        for (int i = 0; i < n - 1; i++) {
            // 길이가 2인 팰린드롬에서 시작
            answer = Math.max(answer, extendPalindrome(s, i, i + 1, n));
            // 길이가 3인 팰린드롬에서 시작
            answer = Math.max(answer, extendPalindrome(s, i, i + 2, n));
        }
        return answer;
    }
    
    public int extendPalindrome(String s, int left, int right, int n) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
