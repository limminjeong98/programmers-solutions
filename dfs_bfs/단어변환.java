import java.util.Arrays;

class Solution {
    
    public static int answer;
    public static int words_size;
    public static int words_length;
    
    public int solution(String begin, String target, String[] words) {
        // 변환할 수 없는 경우
        if (!Arrays.asList(words).contains(target)) return 0;
        
        // 50개 이하의 단어가 있음
        answer = 51;
        
        words_size = words.length;
        words_length = words[0].length();
        
        boolean[] visited = new boolean[words_size];
        
        dfs(begin, target, words, visited, 0);
        return answer == 51 ? 0 : answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words_size; i++) {
            if (visited[i]) continue;
            
            int diff = 0;
            for (int j = 0; j < words_length; j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
                if (diff > 1) break;
            }
            
            if (diff == 1) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count + 1);
                visited[i] = false;  
            }
            
        }
    }    
}
