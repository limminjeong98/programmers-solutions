class Solution {
    public static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, numbers.length, 0, target);
        return answer;
    }

    public void dfs(int[] nums, int cnt, int n, int sum, int target) {
        if (cnt == n) {
            if (sum == target) {
                answer++;
            }
        } else {
            dfs(nums, cnt + 1, n, sum + nums[cnt], target);
            dfs(nums, cnt + 1, n, sum - nums[cnt], target);

        }
    }
}