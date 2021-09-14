def solution(price, money, count):
    total, answer = 0, 0
    for i in range(1, count+1):
        total += i
    answer = total * price - money
    if answer < 0:
        answer = 0
    return answer