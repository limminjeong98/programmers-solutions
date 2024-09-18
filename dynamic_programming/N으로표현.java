import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // N 사용 횟수별로 어떤 값들이 존재하는지 저장
        List<Set<Integer>> dp = new ArrayList<>();
        // N 사용 횟수가 8보다 크면 -1을 리턴
        for (int i = 0; i < 8; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(0).add(N);
        
        for (int i = 2; i <= 8; i++) {
            int tmp = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i - 1).add(tmp);
            
            for (int j = 1; j < i; j++) {
                // i = j + k인 num1, num2의 조합으로 구하기 (dp)
                int k = i - j;
                for (int num1 : dp.get(j - 1)) {
                    for (int num2 : dp.get(k - 1)) {
                        dp.get(i - 1).add(num1 + num2);
                        dp.get(i - 1).add(num1 - num2);
                        dp.get(i - 1).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i - 1).add(num1 / num2);
                        }
                    }
                }
            }
            
            if (dp.get(i - 1).contains(number)) return i;
        }
        return -1;
    }
}
