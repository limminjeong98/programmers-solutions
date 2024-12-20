import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667

class Solution {
    public static int solution(int[] queue1, int[] queue2) {

        int length = queue1.length;

        long sum = 0;
        long leftSum = 0;

        for (int i = 0; i < length; i++) {
            sum += queue1[i];
            sum += queue2[i];
            leftSum += queue1[i];
        }

        // 홀수라면 반으로 나눌 수 없음
        if (sum % 2 == 1) return -1;

        long half = sum / 2;

        int left = 0, right = length;

        int[] q = new int[length * 2];
        System.arraycopy(queue1, 0, q, 0, length);
        System.arraycopy(queue2, 0, q, length, length);

        int count = 0;

        while (left < length * 2 && right < length * 2) {
            if (leftSum == half) return count;
            // 왼쪽 큐의 합이 절반보다 작으면 오른쪽 큐의 첫번째 원소를 왼쪽 큐로 이동시킨다
            if (leftSum < half) {
                leftSum += q[right];
                right++;
            } else {
                // 왼쪽 큐의 합이 절반보다 크다면 오른쪽 큐의 맨 뒤로 왼쪽 큐의 첫번째 원소를 이동시킨다
                leftSum -= q[left];
                left++;
            }
            count++;
        }

        return -1;
    }
}
