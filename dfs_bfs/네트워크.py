from collections import deque
def solution(n, computers):
    answer = 0
    visited = [False] * n
    def bfs(x):
        q = deque([x])
        while q:
            now = q.popleft()
            visited[now] = True
            for i in range(n):
                if computers[now][i] == 1 and not visited[i]:
                    q.append(i)       
    for i in range(n):
        if not visited[i]:
            bfs(i)
            answer += 1
    return answer