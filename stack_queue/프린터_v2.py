def solution(priorities, location):
    answer = 0
    cnt = 0
    tmp = 0
    length = len(priorities)
    while 1:
        if max(priorities) > priorities[0]:
            priorities = priorities[1:] + [priorities[0]]
        else:
            priorities = priorities[1:] + [0]
            tmp += 1
            if cnt == location:
                answer = tmp
                break
        cnt += 1
        if cnt >= length:
            cnt -= length
    return answer