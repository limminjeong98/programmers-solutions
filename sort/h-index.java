import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            // 인용된 논문의 수
            int h = n - i;
            // 가장 적게 인용된 논문의 인용 횟수가 h를 넘는다면
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
