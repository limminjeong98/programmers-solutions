class Solution {
    public int solution(int[] numbers, int target) {
        // class 변수로 선언 안하고 메서드 파라미터로 answer 전달하기 위해
        int[] answer = new int[1];
        dfs(numbers, target, answer, numbers.length, 0, 0);
        return answer[0];
    }
    
    public void dfs(int[] numbers, int target, int[] answer, int n, int count, int sum) {
        if (count == n) {
            if (sum == target) {
                answer[0]++;
            }
            return;
        }
        dfs(numbers, target, answer, n, count + 1, sum + numbers[count]);
        dfs(numbers, target, answer, n, count + 1, sum - numbers[count]);
    }
}
