import java.util.*;

// 2024 KAKAO WINTER INTERNSHIP 가장 많이 받은 선물
// https://school.programmers.co.kr/learn/courses/30/lessons/258712

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;

        Map<String, Integer> nameMap = new HashMap<>();

        for (int i = 0 ; i < n; i++) {
            nameMap.put(friends[i], i);
        }

        int[][] scores = new int[n][n];
        int[] scoreSum = new int[n];

        for (String gift : gifts) {
            String[] str = gift.split(" ");
            String from = str[0];
            String to = str[1];

            scores[nameMap.get(from)][nameMap.get(to)] += 1;
            scores[nameMap.get(to)][nameMap.get(from)] -= 1;
            scoreSum[nameMap.get(from)] += 1;
            scoreSum[nameMap.get(to)] -= 1;
        }

        for (int i = 0; i < n; i++) {
            // 자신이 받은 선물의 수
            int count = 0;
            for (int j = 0; j < n; j++) {
                // 본인은 제외
                if (i == j) continue;
                // 두 사람이 선물을 주고받은 기록이 있다면
                if (scores[i][j] != 0) {
                    if (scores[i][j] > scores[j][i]) {
                        count += 1;
                    }
                } else {
                    if (scoreSum[i] > scoreSum[j]) {
                        count += 1;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
