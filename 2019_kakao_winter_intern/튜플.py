from collections import defaultdict
def solution(s):
    answer = []
    s = s[1:-1]
    s = list(map(str, s.split(',')))
    sdict = {}
    for i in s:
        i = i.replace('{', '')
        i = i.replace('}', '')
        sdict[i] = sdict.get(i, 0) + 1
    slist = list(zip(sdict.keys(), sdict.values()))
    slist.sort(key=lambda x: -x[1])
    for s in slist:
        answer.append(int(s[0]))
    return answer