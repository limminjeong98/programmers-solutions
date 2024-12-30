// https://school.programmers.co.kr/learn/courses/30/lessons/12979

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int position = 0;
        int index = 0;
        int size = stations.length;
        
        while (position < n) {
            // 설치된 기지국에서 전파를 받을 수 있는 경우
            if (index < size && position >= stations[index] - 1 - w) {
                // 기지국에서 닿지 못하는 곳부터 다시 점검
                position = stations[index] - 1 + w + 1;
                index++;
            } else {
                // 기지국 설치
                answer++;
                position += 2 * w + 1;
            }
        }

        return answer;
    }
}
