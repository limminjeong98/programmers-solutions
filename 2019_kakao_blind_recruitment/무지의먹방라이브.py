from heapq import heappop, heappush

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    q = []
    for i in range(len(food_times)):
        heappush(q, (food_times[i], i+1))
    
    total = 0
    tmp = 0
    length = len(q)

    while total + (q[0][0] - tmp) * length <= k:
        now = heappop(q)[0]
        total += (now-tmp) * length
        length -= 1
        tmp = now

    result = sorted(q, key=lambda x:x[1])
    return result[(k-total) % len(q)][1]
