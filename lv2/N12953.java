import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12953

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 최소 공배수 lcm (least common multiple)
            if (answer <= arr[i]) {
                answer = answer * arr[i] / gcd(answer, arr[i]);
            } else {
                answer = answer * arr[i] / gcd(arr[i], answer);
            }
            
        }
        return answer;
    }
    
    // 최대 공약수(greatest common divisor)
    public int gcd(int a, int b) {
        int rem = b % a;
        if (rem == 0) return a;
        return gcd(rem, a);
    }
}
