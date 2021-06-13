import heapq

def solution(operations):
    answer = []
    minh = []
    maxh = []
    for operation in operations:
        com, data = operation.split()
        if com == 'I':
            heapq.heappush(minh, int(data))
            heapq.heappush(maxh, -int(data))
        elif com == 'D':
            if len(minh) == 0:
                continue
            if data[0] == '-':
                minvalue = heapq.heappop(minh)
                maxh.remove(-minvalue)
            else:
                maxvalue = -heapq.heappop(maxh)
                minh.remove(maxvalue)
    if len(minh) == 0:
        return [0, 0]
    answer = [-heapq.heappop(maxh), heapq.heappop(minh)]
    return answer