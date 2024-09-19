import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // a[0] - b[0]이 아니라 a[1] - b[1]로 해야하는 이유 잘 생각하기
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int location = routes[0][1];
        answer = 1;
        for (int[] route : routes) {
            // 진입시점에 카메라가 설치되어있지 않았다면
            if (route[0] > location) {
                location = route[1];
                answer++;
            }
        }
        return answer;
    }
}
