import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/134239

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int length = ranges.length;
        double[] answer = new double[length];
        
        List<Long> nums = new ArrayList<>();
        nums.add((long)k);
        
        // k가 1이 될때까지의 수
        long kLong = (long)k;
        long n = 0L;
        while (kLong != 1L) {
            if (kLong % 2 == 0) {
                kLong /= 2;
                nums.add(kLong);
            } else {
                kLong *= 3;
                kLong += 1;
                nums.add(kLong);
            }
            n++;
        }
        
        int size = nums.size();
        
        for (int i = 0; i < length; i++) {
            int[] range = ranges[i];
            int start = range[0];
            long end = n + range[1];
            
            if (start > end || end >= size) {
                answer[i] = -1.0;
            } else if (start == end) {
                answer[i] = 0;
            } else {
                double sum = 0.0;
                for (int j = start; j < end; j++) {
                    sum += (nums.get(j) + nums.get(j + 1)) / 2.0;
                }
                answer[i] = sum;
            }
        }
        return answer;
    }
}
