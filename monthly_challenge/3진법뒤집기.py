def solution(n):
    answer = 0
    tmp = ''
    while n // 3 > 0:
        tmp = str(n % 3) + tmp
        n //= 3
    if n != 0:
        tmp = str(n % 3) + tmp
    tmp = list(tmp)
    tmp = tmp[::-1]
    tmp = ''.join(map(str, tmp))
    for i in range(len(tmp)):
        if int(tmp[i]) != 0:
            answer += 3**(len(tmp)-1-i) * int(tmp[i]) 
    return answer