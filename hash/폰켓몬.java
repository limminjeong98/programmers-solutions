import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        if (map.size() < n / 2) {
            answer = map.size();
        } else {
            answer = n / 2;
        }

        return answer;
    }
}
