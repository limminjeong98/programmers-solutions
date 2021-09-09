def solution(citations):
    answer = 0
    length = len(citations)
    cnt = 1
    while cnt <= length:
        tmp = 0
        for i in range(length):
            if citations[i] >= cnt:
                tmp += 1
        if tmp >= cnt:
            answer = cnt
        cnt += 1
    return answer