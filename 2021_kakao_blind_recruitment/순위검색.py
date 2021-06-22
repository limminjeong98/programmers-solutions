from itertools import combinations
from collections import defaultdict

def solution(info, query):
    answer = []
    info_dict = defaultdict(list)
    for e in info:
        e = e.split()
        score = int(e[-1])
        e = e[:-1]
        for i in range(5):
            for c in combinations(e, i):
                tmp = ''.join(c)
                info_dict[tmp].append(score)

    for i in info_dict.keys():
        info_dict[i].sort()
    for q in query:
        q = q.replace('-', '')
        q = q.replace(' and ', '')
        q = q.split()
        target = int(q[-1])
        entire = q[:-1]
        entire = ''.join(entire)
        if entire in info_dict:
            scores = info_dict[entire]
            start = 0
            end = len(scores)
            while start < end:
                mid = (start + end) // 2
                if scores[mid] >= target:
                    end = mid
                else:
                    start = mid + 1
            answer.append(len(scores) - start)
        else:
            answer.append(0)
    return answer