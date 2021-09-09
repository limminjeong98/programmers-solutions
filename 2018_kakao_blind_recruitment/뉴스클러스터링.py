def solution(str1, str2):
    answer = 0
    jdict1, jdict2 = {}, {}
    len1, len2 = len(str1), len(str2)
    for i in range(len1-1):
        tmp = str1[i:i+2]
        if not (tmp[0].isalpha() and tmp[1].isalpha()):
            continue
        tmp = tmp.lower()
        if tmp in jdict1:
            jdict1[tmp] += 1
        else:
            jdict1[tmp] = 1
    print(jdict1.keys())
    for i in range(len2-1):
        tmp = str2[i:i+2]
        if not (tmp[0].isalpha() and tmp[1].isalpha()):
            continue
        tmp = tmp.lower()
        if tmp in jdict2:
            jdict2[tmp] += 1
        else:
            jdict2[tmp] = 1
    co, to = 0, 0
    for k in jdict1.keys():
        if k in jdict2.keys():
            co += min(jdict1[k], jdict2[k])
            to += max(jdict1[k], jdict2[k])
        else:
            to += jdict1[k]
    for k in jdict2.keys():
        if k not in jdict1.keys():
            to += jdict2[k]
    if to != 0:
        answer = 65536 * co / to
    else:
        answer = 65536
    return int(answer)