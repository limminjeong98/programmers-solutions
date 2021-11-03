from heapq import heappop, heappush
def solution(n, edges):
    answer = 0
    INF = int(1e9)
    distance = [INF] * (n + 1)
    graph = [[] for _ in range(n + 1)]
    distance[1] = 0
    distance[0] = -1
    h = []
    for edge in edges:
        a, b = edge
        graph[a].append((1, b))
        graph[b].append((1, a))
        if a == 1:
            heappush(h, (1, b))
            distance[b] = 1
        if b == 1:
            heappush(h, (1, a))
            distance[a] = 1
    while h:
        d, now = heappop(h)
        for i in graph[now]:
            cost, node = i
            if distance[node] > cost + d + 1:
                distance[node] = cost + d + 1
                heappush(h, (cost + d + 1, node))

    answer = distance.count(max(distance))
    return answer