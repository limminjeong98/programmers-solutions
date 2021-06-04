from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque(priorities)
    cnt = 0
    while q:
        if max(q) == q[0]:
            q.popleft()
            cnt += 1
            if location == 0:
                answer = cnt
                break
        else:
            q.append(q.popleft())
        location -= 1
        if location < 0:
            location = len(q) - 1
    return answer