import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, ArrayList<Integer>> playMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + plays[i]);
            
            // 컴파일 에러
            // playMap.put(genre, playMap.getOrDefault(genre, new ArrayList<>()).add(i));
            // computeIfAbsent 메서드를 사용하면 된다 (putIfAbsent는 반환값이 없음)
            playMap.computeIfAbsent(genre, x -> new ArrayList<>()).add(i);
        }
        
        // 속한 노래가 가장 많은 장르를 먼저 수록
        List<String> genreKeyList = new ArrayList<>(genreMap.keySet());
        // value값을 기준으로 내림차순 정렬
		    genreKeyList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
        
        // 장르별로 가장 많이 재생된 노래를 두개씩 출시
        for (String genre : genreKeyList) {
            List<Integer> playIdxList = new ArrayList<>(playMap.get(genre));
            // 장르 내에서 많이 재생된 노래를 먼저 수록, 재생 횟수가 같으면 인덱스가 작은 노래를 먼저 수록
            playIdxList.sort((o1, o2) -> {
                if (plays[o2] != plays[o1]) return plays[o2] - plays[o1];
                else return o1 - o2;
            });
            
            int cnt = 0;
            for (Integer play : playIdxList) {
                if (cnt == 2) break;
                answer.add(play);
                cnt++;
            }
        }
        // List<Integer> -> int[]로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
