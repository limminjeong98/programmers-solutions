def solution(triangle):
    answer = 0
    n = len(triangle)
    dp = [[0] * n for _ in range(n)]
    dp[0][0] = triangle[0][0]
    for i in range(1, n):
        for j in range(i+1):
            if j == 0:
                right = dp[i-1][j]
                left = 0
            elif j == i:
                right = 0
                left = dp[i-1][j-1]
            else:
                right = dp[i-1][j]
                left = dp[i-1][j-1]
            dp[i][j] = max(left, right)
            dp[i][j] += triangle[i][j]
    answer = max(dp[n-1])
    return answer