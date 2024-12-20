import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/49993

class Solution {
    public int solution(String skill, String[] skill_trees) {
         int answer = 0;

        for (String str : skill_trees) {
            boolean flag = true;
            int skillIndex = 0;
            for (char c : str.toCharArray()) {
                int index = skill.indexOf(c);
                // skill에 포함되지 않은 글자이면 무시
                if (index == -1) continue;
                // skill에 포함된 글자이지만, 이 글자보다 먼저 방문해야하는 글자가 있었다면
                // 즉 인덱스가 다르다면, 앞에서 다른 스킬을 먼저 배워야하므로 불가능한 경우임
                if (skillIndex != index) {
                    flag = false;
                    break;
                }
                skillIndex++;
            }
            if (flag) answer++;
        }
        return answer;
    }
}
