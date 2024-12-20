import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17684

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        // 사전의 마지막 value
        int index = 1;

        // A ~ Z
        for (int i = 65; i <= 90; i++) {
            String s = String.valueOf((char) i);
            // 사전에 알파벳 대문자를 추가하면서 value를 순차적으로 증가시킨다
            dict.put(s, index++);
        }

        int position = 0;
        int length = msg.length();
        while (position < length) {
            // 현재 입력과 일치하는 가장 긴 문자열을 찾는다
            int lastPosition = position + 1;
            while (lastPosition <= length) {
                String str = msg.substring(position, lastPosition);
                if (!dict.containsKey(str)) break;
                else lastPosition++;
            }

            String existStr = msg.substring(position, lastPosition - 1);

            // 사전에 등록된 가장 긴 단어의 번호를 출력
            answer.add(dict.get(existStr));
            
            // 다음 글자를 포함한 단어를 사전에 등록
            if (lastPosition <= length)
                dict.put(msg.substring(position, lastPosition), index++);

            position = lastPosition - 1;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
