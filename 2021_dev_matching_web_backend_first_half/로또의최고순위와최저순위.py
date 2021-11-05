def solution(lottos, win_nums):
    answer = []
    lottos.sort()
    win_nums.sort()
    cnt = 0
    rst = 0
    for lotto in lottos:
        if lotto in win_nums:
            cnt += 1
        elif lotto == 0:
            rst += 1
    if cnt + rst >= 2:
        answer.append(7- (cnt + rst))
    else:
        answer.append(6)
    if cnt >= 2:
        answer.append(7 - cnt)
    else:
        answer.append(6)
    return answer