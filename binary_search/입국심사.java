import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int examiner = times.length;
        Arrays.sort(times);
        
        long left = 0;
        // n 최대 100,000이고 times의 최대값은 1,000,000,000 이므로 long 타입 변환 필요
        // 가장 심사가 오래 걸리는 검사관이 모든 사람의 입국 심사를 수행한다고 했을 때 걸리는 시간
        long right = n * (long)times[examiner - 1];
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            // mid 시간동안 심사관별로 몇명을 검사할 수 있는지
            for (int i = 0; i < examiner; i++) {
                sum += mid / times[i];
            }
            // n명을 검사하지 못한다면 안되므로 시간을 늘려야함
            if (sum < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
