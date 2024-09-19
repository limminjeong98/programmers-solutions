import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while (left < right) {
            // 가장 무거운 사람 먼저 태우고, 태울 수 있으면 가벼운 사람도 같이 태움
            int tmp = people[right];
            if (tmp + people[left] <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        // 마지막에 한명이 남은 경우 태워야함
        if (left == right) {
            answer++;
        }
        return answer;
    }
}
