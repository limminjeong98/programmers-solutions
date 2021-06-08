dx = [0, 1]
dy = [1, 0]
from collections import deque
def solution(m, n, puddles):
    answer = 0
    maps = [[0] * m for _ in range(n)]
    maps[0][0] = 1
    q = deque([])
    q.append((0, 0))
    while q:
        x, y = q.popleft()
        for r in range(2):
            nx, ny = x + dx[r], y + dy[r]
            if 0 <= nx < n and 0 <= ny < m:
                if [ny+1, nx+1] in puddles:
                    continue
                maps[nx][ny] += maps[x][y]
                if (nx, ny) not in q:
                    q.append((nx, ny))
    answer = maps[n-1][m-1] % 1000000007
    return answer