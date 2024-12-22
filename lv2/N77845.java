// https://school.programmers.co.kr/learn/courses/30/lessons/77485

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int length = queries.length;
        int[] answer = new int[length];
        int[][] maps = new int[rows][columns];
        
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maps[i][j] = value;
                value++;
            }
        }
        
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            answer[i] = rotate(maps, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }
        return answer;
    }
    
    public int rotate(int[][] maps, int startRow, int startColumn, int endRow, int endColumn) {
        int minValue = maps[startRow][startColumn];
        // 복제본
        int[][] splits = new int[endRow - startRow + 1][endColumn - startColumn + 1];
        
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                if (i != startRow && i != endRow && j != startColumn && j != endColumn) {
                    // 사각형 테두리가 아니라 내부인 경우 이동하지 않는다 (그대로 채운다)
                    splits[i - startRow][j - startColumn] = maps[i][j];
                } else if (i == startRow) {
                    // 맨 윗줄은 맨 왼쪽 칸을 제외하고 오른쪽으로 한칸씩 이동한다
                    if (j != startColumn) splits[i - startRow][j - startColumn] = maps[i][j - 1];
                    else splits[i - startRow][j - startColumn] =  maps[i + 1][j];
                    minValue = Math.min(minValue, splits[i - startRow][j - startColumn]);
                } else if (i == endRow) {
                    // 맨 아랫줄은 맨 오른쪽 칸을 제외하고 왼쪽으로 한칸씩 이동한다
                    if (j != endColumn) splits[i - startRow][j - startColumn] = maps[i][j + 1];
                    else splits[i - startRow][j - startColumn] =  maps[i - 1][j];
                    minValue = Math.min(minValue, splits[i - startRow][j - startColumn]);
                } else if (j == startColumn) {
                    // 첫번째 줄이거나 마지막열이 아닌 맨 왼쪽 열은 한칸씩 위로 이동한다
                    splits[i - startRow][j - startColumn] =  maps[i + 1][j];
                    minValue = Math.min(minValue, splits[i - startRow][j - startColumn]);
                } else if (j == endColumn) {
                    // 첫번째 줄이거나 마지막열이 아닌 맨 오른쪽 열은 한칸씩 아래로 이동한다
                    splits[i - startRow][j - startColumn] =  maps[i - 1][j];
                    minValue = Math.min(minValue, splits[i - startRow][j - startColumn]);
                }
            }
        }
        
        // maps 배열에 저장
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                maps[i][j] = splits[i - startRow][j - startColumn];
            }
        }
        
        return minValue;
    }
    
}
