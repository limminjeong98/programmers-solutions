import heapq
INF = int(1e9)

def dijkstra(table, n, start, end):
    dist = [INF] * (n+1)
    dist[start] = 0
    h = []
    h.append([0, start])
    while h:
        cost, node = heapq.heappop(h)
        if cost > dist[node]:
            continue
        for n, c in table[node]:
            if c + cost < dist[n]:
                dist[n] = c + cost
                heapq.heappush(h, [dist[n], n])
    return dist[end]
                
def solution(n, s, a, b, fares):
    cost = [[] for _ in range(n+1)]
    for fare in fares:
        c, d, f = fare
        cost[c].append([d, f])
        cost[d].append([c, f])
    answer = dijkstra(cost, n, s, a) + dijkstra(cost, n, s, b)
    for i in range(1, n+1):
        if i != s:
            answer = min(answer, dijkstra(cost, n, s, i) + dijkstra(cost, n, i, a) + dijkstra(cost, n, i, b))
    return answer