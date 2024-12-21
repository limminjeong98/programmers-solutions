// https://school.programmers.co.kr/learn/courses/30/lessons/135807

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int l1 = arrayA.length;
        int l2 = arrayB.length;
        
        // # 1 
        int answer1 = -1;
        boolean flag1 = true;
        // arrayA의 greatest common divisor
        int gcd1 = arrayA[0];
        for (int i = 1; i < l1; i++) {
            gcd1 = gcd(gcd1, arrayA[i]);
        }
        
        for (int i = 0; i < l2; i++) {
            if (arrayB[i] % gcd1 == 0) {
                flag1 = false;
                break;
            }
        }
        
        if (flag1 == true) answer1 = gcd1; 
        
        // # 12
        int answer2 = -1;
        boolean flag2 = true;
        // arrayB의 greatest common divisor
        int gcd2 = arrayB[0];
        for (int i = 1; i < l2; i++) {
            gcd2 = gcd(gcd2, arrayB[i]);
        }
        
        for (int i = 0; i < l1; i++) {
            if (arrayA[i] % gcd2 == 0) {
                flag2 = false;
                break;
            }
        }
        
        if (flag2 == true) answer2 = gcd2; 
        
        // 영희의 lcm
        return Math.max(answer1, answer2) == -1 ? 0 : Math.max(answer1, answer2);
    }
    
    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
