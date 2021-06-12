import heapq
def check(h, k):
    for i in h:
        if i < k:
            return False
    return True

def solution(scoville, k):
    answer = 0
    h = []
    for i in scoville:
        heapq.heappush(h, i)
    
    while True:
        if len(h) == 1: 
            return -1
        first = heapq.heappop(h)
        second = heapq.heappop(h)
        heapq.heappush(h, first + second*2)
        answer += 1
        if check(h, k):
            return answer