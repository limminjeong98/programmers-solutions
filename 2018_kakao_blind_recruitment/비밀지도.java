import java.util.List;
import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    
    public char[][] map;
    public String map1, map2;
    public List<String> answer;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        answer = new ArrayList<String>();
        map = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            map1 = translateBinary(n, arr1[i]);
            map2 = translateBinary(n, arr2[i]);
            for (int j = 0; j < n; j++) {
                if (map1.charAt(j) == '0' && map2.charAt(j) == '0') {
                    map[i][j] = ' ';
                } else {
                    map[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            answer.add(new String(map[i]));
        }
        return answer.toArray(new String[answer.size()]);
    }
    public String translateBinary(int n, int target) {
        String str = Integer.toBinaryString(target);
        str = "0".repeat(n - str.length()) + str;
        return str;
    }
}
