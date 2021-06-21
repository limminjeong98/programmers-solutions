def balanced(p):
    cnt = 0
    for i in range(len(p)):
        if p[i] == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt == 0:
            return i
def correct(p):
    cnt = 0
    for i in range(len(p)):
        if p[i] == '(':
            cnt += 1
        else:
            if cnt < 1:
                return False
            cnt -= 1
    if cnt != 0:
        return False
    return True
                
def solution(p):
    answer = ''
    if p == '': 
        return ''
    index = balanced(p)
    u = p[:index+1]
    v = p[index+1:]
    if correct(u):
        answer = u + solution(v)
    else:
        answer += '('
        answer += solution(v)
        answer += ')'
        for i in range(1, len(u)-1):
            if u[i] == '(':
                answer += ')'
            else:
                answer += '('
    
    return answer