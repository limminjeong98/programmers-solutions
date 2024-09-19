// import java.util.List;
// import java.util.ArrayList;
// import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        // 각 시점별 가격이 떨어지지 않은 기간의 최대값으로 초기화
        for (int i = 0; i < n; i++) {
            answer[i] = n - i - 1;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        // 이전보다 가격이 떨어지지 않았다면, 각 시점의 인덱스를 저장하고
        // 떨어졌다면 스택에서 팝하고, 떨어진 시점까지의 기간을 업데이트
        stack.push(0);
        
        // 맨 마지막 시점은 확인할 필요 없으므로 n - 1 시점만 확인하면 됨
        for (int i = 1; i < n; i++) {
            // 현재까지 가장 비쌌던 가격보다 비싸다면
            while (stack.size() > 0) {
                int idx = stack.peek(); 
                // deque에서는 getFirst()와 같음
                // deque에서 getLast()는 가장 예전에 삽입된 원소, 즉 스택 맨 밑에 있는 원소를 반환함
                if (prices[idx] > prices[i]) {
                    answer[idx] = i - idx;
                    stack.pop();
                    // deque에서는 removeLast()와 같음
                } else {
                    // 스택의 원소가 이전보다 가격이 떨어지지 않았다면, 스택에 현재 시점에 해당하는 인덱스만 추가
                    break;
                }
            }
            // 현재 시점도 확인하기 위해 삽입
            stack.push(i);
        }
        
        return answer;
        
        // for (int i = 1; i < n; i++) {
        //     while (stack.size() > 0) {
        //         int idx = stack.peek();
        //         if (prices[idx] > prices[i]) {
        //             answer.set(idx, i - idx);
        //             stack.pop();
        //         } else break;
        //     }
        //     stack.push(i);
        // }
        // return answer.stream().mapToInt(i -> i).toArray();
    }
}
