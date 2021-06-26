def solution(gems):
    n = len(set(gems))
    length = len(gems)
    gdict = {gems[0]: 1}
    left, right = 0, 0
    dist, result = 0, 1
    answer = []
    
    while left < length and right < length:
        if len(gdict) < n:
            right += 1
            if right == length:
                break
            gdict[gems[right]] = gdict.get(gems[right], 0) + 1
        else:
            answer.append((right-left, [left+1, right+1]))
            gdict[gems[left]] -= 1
            if gdict[gems[left]] == 0:
                del gdict[gems[left]]
            left += 1
    answer = sorted(answer, key=lambda x: (x[0], x[1]))
    return answer[0][1]