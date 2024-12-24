import java.util.*;
import java.util.stream.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players.clone();
        Map<String, Integer> playerMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String call : callings) {
            int index = playerMap.get(call);
            String frontPlayer = answer[index - 1];
            answer[index - 1] = call;
            answer[index] = frontPlayer;
            playerMap.put(call, index - 1);
            playerMap.put(frontPlayer, index);
        }
        
        return answer;
    }
}
