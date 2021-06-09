def solution(money):
    answer = 0
    n = len(money)
    dp_1, dp_2 = [0 for _ in range(n-1)], [0 for _ in range(n)]
    dp_1[0] = money[0]
    dp_1[1] = max(money[0], money[1])
    for i in range(2, n-1):
        dp_1[i] = max(dp_1[i-1], dp_1[i-2]+money[i])
    dp_2[1] = money[1]
    for i in range(2, n):
        dp_2[i] = max(dp_2[i-1], dp_2[i-2]+money[i])
    answer = max(dp_1[n-2], dp_2[n-1])
    return answer