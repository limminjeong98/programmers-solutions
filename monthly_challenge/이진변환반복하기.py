def solution(s):
    answer = []
    cnt = 0
    num = 0
    while s != '1':
        cnt += 1
        num += s.count('0')
        s = s.split('0')
        s = ''.join(map(str, s))
        c = len(s)
        s = str(bin(c)[2:])
    answer = [cnt, num]
    return answer