def solution(N, number):
    answer = -1
    dp = []
    for i in range(1, 9):
        rst = set()
        now = int(str(N) * i)
        rst.add(now)
        for j in range(i-1):
            for num1 in dp[j]:
                for num2 in dp[-j-1]:
                    rst.add(num1 + num2)
                    rst.add(num1 - num2)
                    rst.add(num1 * num2)
                    if num2 != 0:
                        rst.add(num1 // num2)
        if number in rst:
            answer = i
            break
        dp.append(rst)
    return answer