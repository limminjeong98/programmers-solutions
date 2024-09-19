class Solution {
    public String solution(String number, int k) {
        int length = number.length();
        StringBuilder sb = new StringBuilder();
        
        // 가장 큰 문자열의 시작 인덱스
        int startIndex = 0;
        
        // length - k - 1 번 반복하면서 문자 하나를 찾는다
        // 부분문자열의 시작
        for (int i = 0; i < length - k; i++) {
            char currentMaxChar = '0';
            for (int j = startIndex; j <= i + k; j++) {
                if (currentMaxChar < number.charAt(j)) {
                    currentMaxChar = number.charAt(j);
                    // 다음 반복문부터는 startIndex 이후부터의 문자열 중에서 큰 숫자를 찾을 수 있게 한다
                    startIndex = j + 1;
                }
            }
            sb.append(currentMaxChar);
        }
        
        return sb.toString();
    }
}
