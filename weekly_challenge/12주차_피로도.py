from itertools import permutations
def solution(k, dungeons):
    answer = 0
    n = len(dungeons)
    for dung in list(permutations(dungeons, n)):
        cnt = 0
        current = k
        for i in range(n):
            if current >= dung[i][0]:
                current -= dung[i][1]
                cnt += 1
        answer = max(answer, cnt)
    return answer
print(solution(80, [[80,20],[50,40],[30,10]]))
# 3