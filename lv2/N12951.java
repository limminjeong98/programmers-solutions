import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        // limit 인자가 없는 s.split()을 쓰면 trailing empty string은 discard됨
        // 공백 문자 개수의 limit은 최대 문자열의 길이만큼 존재할 수 있음
        String[] splits = s.split(" ", s.length());

        // System.out.println(Arrays.toString(splits));
        
        for (int i = 0; i < splits.length; i++) {
            String str = splits[i];
            
            if (str.equals("")) continue;
            // 첫 문자를 제외하고는 모두 소문자로 변환
            str = str.toLowerCase();
            
            // 첫 문자가 숫자가 아닐 경우 대문자로 변환
            if (str.charAt(0) < '0' || str.charAt(0) > '9') {
                // Character.toUpperCase()
                // str.toUpperCase()
                str = Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length());
            }
            
            splits[i] = str;
        }

        for (String str : splits) {
            if (str.equals("")) {
                answer.append(" ");
            } else {
                answer.append(str);
                answer.append(" ");
            }
        }
        
        // 마지막 문자 추가하면서 같이 추가한 공백은 지워줘야함
        // 빈 문자열일때도 마찬가지
        // " " -> ["", ""] 
        answer.deleteCharAt(answer.length() - 1);
        return answer.toString();
    }
}
