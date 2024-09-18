import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
// import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리를 건너기 위한 최소 시간
        int answer = 0;
        
        int n = truck_weights.length;
        
        // int[] intArr = new int[bridge_length];
        // Queue<Integer> bridge = new LinkedList(Arrays.stream(intArr).boxed().collect(Collectors.toList()));
        // bridge 큐에는 최대 bridge_length 대의 트럭이 올라갈 수 있음
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
           bridge.offer(0);
        }
        
        // 다리를 건넌 트럭의 수
        int cnt = 0;
        // 다리를 건너는 트럭의 인덱스
        int idx = 0;
        // 다리에 올라간 트럭의 무게
        int sum = 0;
        
        while (cnt < n) {
            // 모든 트럭이 다리를 건너면 종료
            int truck = bridge.poll();
            if (truck > 0) {
                cnt++;
                sum -= truck;
            }
            // 다리에 트럭이 더 올라갈 수 있는지 확인
            if (idx < n) {
                // 현재 다리에 올라간 트럭의 무게의 합을 확인
                if (sum + truck_weights[idx] <= weight) {
                    bridge.offer(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                } else {
                    // 더 올라갈 수 없다면 큐의 개수를 유지하기 위해 0을 삽입
                    bridge.offer(0);
                }
            } else {
                // 모든 트럭이 다리를 건널 때까지 큐의 개수를 유지하기 위해 0을 삽입
                bridge.offer(0);
            }
            answer++;
        }
        
        return answer;
    }
}
