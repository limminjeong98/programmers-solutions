import heapq
def solution(jobs):
    answer = 0
    n = len(jobs)
    now, before = 0, -1
    h = []
    cnt = 0
    while cnt < n:
        for job in jobs:
            if before < job[0] <= now:
                answer += now - job[0]
                heapq.heappush(h, job[1])
        
        if len(h) > 0:
            answer += len(h) * h[0]
            before = now
            now += heapq.heappop(h)
            cnt += 1
        else:
            now += 1
    return answer // n