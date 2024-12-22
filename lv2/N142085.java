import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int died = 0;
        // 적의 수가 큰 순서대로 리턴하기 위한 큐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < enemy.length; i++) {
            maxHeap.offer(enemy[i]);
            died += enemy[i];
            // 총 죽은 병사가 n명이 넘는다면 무적권 사용
            if (died > n) {
                if (k == 0) return i;
                // 무적권을 가장 잘 사용하기 위해 적이 가장 많았던 라운드에 무적권을 사용
                died -= maxHeap.poll();
                k -= 1;
            }
        }
        return enemy.length;
    }
}
