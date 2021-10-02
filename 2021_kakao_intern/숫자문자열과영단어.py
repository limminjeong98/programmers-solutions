def solution(s):
    answer = ''
    length = len(s)
    for i in range(length):
        if s[i].isdigit() and 0 <= int(s[i]) <= 9:
            answer += s[i]
        elif s[i:i+4] == 'zero':
            answer += '0'
        elif s[i:i+3] == 'one':
            answer += '1'
        elif s[i:i+3] == 'two':
            answer += '2'
        elif s[i:i+5] == 'three':
            answer += '3'
        elif s[i:i+4] == 'four':
            answer += '4'
        elif s[i:i+4] == 'five':
            answer += '5'
        elif s[i:i+3] == 'six':
            answer += '6'
        elif s[i:i+5] == 'seven':
            answer += '7'
        elif s[i:i+5] == 'eight':
            answer += '8'
        elif s[i:i+4] == 'nine':
            answer += '9'
            
    return int(answer)