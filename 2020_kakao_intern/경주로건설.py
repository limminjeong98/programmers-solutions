from collections import deque
# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
INF = int(1e9)

def bfs(board, start):
    n = len(board)
    arr = [[INF] * n for _ in range(n)]
    arr[0][0] = 0
    q = deque([start])
    while q:
        x, y, cost, direction = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            ncost = cost + 100 if i == direction else cost + 600
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == 0 and arr[nx][ny] > ncost:
                q.append((nx, ny, ncost, i))
                arr[nx][ny] = ncost
    return arr[n-1][n-1]
                
def solution(board):
    answer = min(bfs(board, (0, 0, 0, 1)), bfs(board, (0, 0, 0, 3)))
    return answer