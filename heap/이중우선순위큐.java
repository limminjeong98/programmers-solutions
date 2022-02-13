import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        // Java PriorityQueue는 min heap을 구현
        Queue<Integer> minh = new PriorityQueue<>();
        Queue<Integer> maxh = new PriorityQueue<>();
        for (String str : operations) {
            String[] arr = str.split(" ");
            int tmp = 0;
            // String은 equals를 사용해 동등 비교
            if (arr[0].equals("I")) {
                minh.offer(Integer.valueOf(arr[1]));
                maxh.offer(-Integer.valueOf(arr[1]));
            } else {
                if (minh.size() <= 0)
                    continue;
                if (Integer.valueOf(arr[1]) < 0) {
                    // 큐에서 최솟값을 삭제
                    // minh에서 삭제하고 같은 값을 maxh에서도 지워줌
                    tmp = minh.poll();
                    maxh.remove(-tmp);
                } else {
                    tmp = maxh.poll();
                    minh.remove(-tmp);
                }
            }
        }
        if (minh.size() == 0)
            return new int[] { 0, 0 };
        if (minh.size() == 1) {
            int tmp = minh.poll();
            return new int[] { tmp, tmp };
        }
        return new int[] { -maxh.poll(), minh.poll() };
    }
}