import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        int mid;
        
        while (left <= right) {
            mid = (left + right) / 2;
            
            int before = 0;
            int removedRock = 0;
            
            // 돌 사이 최소거리 mid가 최대인 것을 만들기 위해서 돌을 최대 n개까지 제거함
            // 돌 사이 최소거리가 mid 이상이 되도록 돌을 최대한 적게 제거함
            for (int rock : rocks) {
                if (rock - before < mid) {
                    removedRock++;
                } else {
                    before = rock;
                }
            }
            
            // 마지막 돌에서 도착지까지
            if (distance - before < mid) {
                removedRock++;
            }
                
            if (removedRock > n) {
                // 돌은 최대 n개까지 제거할 수 있으므로, 돌 사이의 최소 거리 mid를 줄여야한다
                right = mid - 1;
            } else {
                // 돌 사이의 최소거리가 더 먼 경우에도 n개를 제거할 수 있는지 확인한다.
                // answer = Math.max(answer, mid); -> 필요없음
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}
