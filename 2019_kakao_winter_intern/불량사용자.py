from itertools import permutations
def check(uid, bid):
    if len(uid) != len(bid):
        return False
    for i in range(len(bid)):
        if bid[i] == '*':
            continue
        if bid[i] != uid[i]:
            return False
    return True

def solution(user_id, banned_id):
    answer = []
    for case in list(permutations(user_id, len(banned_id))):
        avail = True
        for i, item in enumerate(case):
            if not check(case[i], banned_id[i]):
                avail = False
                break
        case1 = set(case)
        if avail and case1 not in answer:
            answer.append(case1)
    return len(answer)