def solution(progresses, speeds):
    answer = []
    length = len(progresses)
    count = 0
    tmpcount = 0
    while count != length:
        tmpcount = 0
        for i in range(count, len(progresses)):
            progresses[i] += speeds[i]
        for i in range(count, len(progresses)):
            if progresses[i] >= 100:
                count += 1
                tmpcount += 1
            else:
                break
        if tmpcount != 0:
            answer.append(tmpcount)
    return answer