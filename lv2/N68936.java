// https://school.programmers.co.kr/learn/courses/30/lessons/68936

class Solution {
    public int[] solution(int[][] arr) {
        // [0의 개수, 1의 개수]
        int[] answer = new int[2];
        compress(arr, 0, 0, arr.length, answer);
        return answer;
    }
    
    public void compress(int[][] arr, int x, int y, int size, int[] result) {
        // 해당 정사각형의 모든 원소가 같은 값이라면
        if (isUniform(arr, x, y, size)) {
            // 해당 값은 1개로 처리
            result[arr[x][y]]++;
            return;
        }
        // 해당 정사각형을 하나로 처리할 수 없다면 분할해서 처리
        int half = size / 2;
        compress(arr, x, y, half, result);
        compress(arr, x, y + half, half, result);
        compress(arr, x + half, y, half, result);
        compress(arr, x + half, y + half, half, result);
    }
    
    
    public boolean isUniform(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
