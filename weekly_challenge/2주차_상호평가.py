def grade(mean):
    if mean >= 90:
        return 'A'
    if mean >= 80:
        return 'B'
    if mean >= 70:
        return 'C'
    if mean >= 50:
        return 'D'
    return 'F'


def solution(scores):
    n = len(scores)
    answer = []
    for i in range(n):
        tmp = []
        tmp_scores = []
        for j in range(n):
            tmp.append((scores[j][i], j))
            tmp_scores.append(scores[j][i])
        tmp.sort()
        tmp_scores.sort()
        max_value = tmp[0][0]
        min_value = tmp[n-1][0]
        if tmp_scores.count(max_value) == 1 and scores[i][i] == max_value:
            tmp_scores.remove(max_value)
        if tmp_scores.count(min_value) == 1 and scores[i][i] == min_value:
            tmp_scores.remove(min_value)
        num = len(tmp_scores)
        point = sum(tmp_scores) // num
        now = grade(point)
        answer.append(now)
                
    answer = ''.join(answer)
    return answer