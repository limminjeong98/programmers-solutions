import java.util.List;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        // int[] answer = {};
        List<Integer> answer = new LinkedList<>();
        
        for (int num : arr) {
            int size = answer.size();
            if (size == 0) {
                answer.add(num);
            } else {
                // 배열에 연속적으로 나타나는 숫자는 하나만 남기고 제거
                if (answer.get(size - 1) != num) {
                    answer.add(num);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
