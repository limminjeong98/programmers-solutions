def check(answer):
    for i in answer:
        x, y, a = i
        # 기둥
        if a == 0:
            if not (y == 0 or [x, y-1, 0] in answer or [x, y, 1] in answer or [x-1, y, 1] in answer):
                return False
        else:
            if not ([x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer)):
                return False
    return True
                
def solution(n, build_frame):
    answer = []
    for frame in build_frame:
        x, y, a, b = frame
        if b == 1:
            answer.append([x, y, a])
            if not check(answer):
                answer.remove([x, y, a])
        else:
            answer.remove([x, y, a])
            if not check(answer):
                answer.append([x, y, a])

    answer.sort()        
    return answer

print(solution(5, [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]))