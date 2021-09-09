def solution(progresses, speeds):
    answer = []
    while progresses:
        length = len(progresses)
        for i in range(length):
            progresses[i] += speeds[i]
        tmp = 0
        for i in range(length):
            if progresses[i] >= 100:
                tmp += 1
            else:
                break
        if tmp > 0:
            progresses = progresses[tmp:]
            speeds = speeds[tmp:]
            answer.append(tmp)
    return answer