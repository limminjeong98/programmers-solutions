// https://school.programmers.co.kr/learn/courses/30/lessons/147355

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n = p.length();
        
        Long number = Long.valueOf(p);
        
        for (int i = 0; i <= t.length() - n; i++) {
            String target = t.substring(i, i + n);
            if (Long.valueOf(target) <= number) {
                answer++;
            }
        }
        return answer;
    }
}
