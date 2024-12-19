import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int n = want.length;
        List<String> items = List.of(want);

        int DAY = 10;
        int length = discount.length;
        List<String> discountList = Arrays.stream(discount).collect(Collectors.toList());

        for (int i = 0; i <= length - DAY; i++) {
            // 10일간 마트에서 할인하는 품목
            List<String> currentDiscount = discountList.subList(i, i + DAY);
            
            // 사야하는 제품별 수량
            int[] itemCount = number.clone();

            for (int j = 0; j < DAY; j++) {
                String item = currentDiscount.get(j);
                if (items.contains(item)) {
                    itemCount[items.indexOf(item)] -= 1;
                }
            }

            boolean flag = true;
            
            // 사야하는 제품별 수량이 남아있는지 확인
            for (int j = 0; j < n; j++) {
                if (itemCount[j] > 0) {
                    flag = false;
                    break;
                }
            }

            if (!flag) continue;
            answer++;
        }
        return answer;
    }
}
