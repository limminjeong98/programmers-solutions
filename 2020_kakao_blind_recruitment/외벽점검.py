from itertools import permutations

def solution(n, weak, dist):
    answer = len(dist) + 1
    length = len(weak)
    for i in range(length):
        weak.append(weak[i]+n)
#         취약지점의 위치를 시작점으로 하여 확인
    for start in range(length):
        for friends in list(permutations(dist, len(dist))):
            cnt = 1
            position = weak[start] + friends[cnt-1]
            for i in range(start, start + length):
                if position < weak[i]:
                    cnt += 1
                    if cnt > len(dist):
                        break
                    position = friends[cnt-1] + weak[i]
            answer = min(answer, cnt)            
    if answer > len(dist):
        return -1
    return answer

print(solution(12, [1, 5, 6, 10], [1, 2, 3, 4]))