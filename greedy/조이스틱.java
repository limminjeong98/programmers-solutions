class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        // 0 ~ length -1 인덱스까지 오른쪽으로 순서대로 탐색하는 경우
        int minMove = length - 1;
        
        for (int i = 0; i < length; i ++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }
        
        // 각 인덱스를 기준으로 하여 전체 최소 이동 횟수를 계산
        for (int index = 0; index < length; index++) {
            int nextIndex = index + 1;
            
            // 오른쪽에 더 이상 A가 아닌 문자를 찾을 때까지 탐색
            // 이동 횟수는 nextIndex - index
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            
            // 현재 인덱스까지 바꾼 후 뒤로 돌아가서 바꾸는 경우
            minMove = Math.min(minMove, index * 2 + length - 1 - nextIndex + 1);
            minMove = Math.min(minMove, 1 + (length - 1 - nextIndex) * 2 + 1 + index);
        }
        
        answer += minMove;
        return answer;
    }
}
// https://hstory0208.tistory.com/entry/Java%EC%9E%90%EB%B0%94-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv2-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-Greedy%ED%83%90%EC%9A%95%EB%B2%95
