def solution(weights, head2head):
    answer = []
    n = len(weights)
    win_percent = [0] * n
    win_big_weight = [0] * n
    sorted_weight = sorted(weights)
    for i in range(n):
        tmp_win, big_win = 0, 0
        all_cnt = 0
        for j in range(n):
            if head2head[i][j] == 'N':
                continue
            all_cnt += 1
            if head2head[i][j] == 'W':
                tmp_win += 1
                if weights[j] > weights[i]:
                    big_win += 1
        if all_cnt == 0:
            win_percent[i] = 0
        else:
            win_percent[i] = tmp_win / all_cnt
        win_big_weight[i] = big_win
    total_arr = []
    for i in range(n):
        total_arr.append((win_percent[i], win_big_weight[i], weights[i], i+1))
    total_arr.sort(key = lambda x: (-x[0], -x[1], -x[2], x[3]))
    for i in range(n):
        answer.append(total_arr[i][3])
    return answer