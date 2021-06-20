from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def get_next_pos(pos, arr):
    next_pos = []
    pos = list(pos)
    x1, y1, x2, y2 = pos[0][0], pos[0][1], pos[1][0], pos[1][1]
    for i in range(4):
        nx1, ny1, nx2, ny2 = x1 + dx[i], y1 + dy[i], x2 + dx[i], y2 + dy[i]
        if arr[nx1][ny1] == 0 and arr[nx2][ny2] == 0:
            next_pos.append({(nx1, ny1), (nx2, ny2)})
            
    if x1 == x2:
        for i in [-1, 1]:
            if arr[x1+i][y1] == 0 and arr[x2+i][y2] == 0:
                next_pos.append({(x1, y1), (x1+i, y1)})
                next_pos.append({(x2, y2), (x2+i, y2)})
    if y1 == y2:
        for i in [-1, 1]:
            if arr[x1][y1+i] == 0 and arr[x2][y2+i] == 0:
                next_pos.append({(x1, y1), (x1, y1+i)})
                next_pos.append({(x2, y2), (x2, y2+i)})
    return next_pos
            
def solution(board):
    answer = 0
    n = len(board)
    arr = [[1] * (n+2) for _ in range(n+2)]
    for i in range(n):
        for j in range(n):
            arr[i+1][j+1] = board[i][j]
    q = deque()
    visited = []
    pos = {(1,1), (1,2)}
    q.append((pos, 0))
    visited.append(pos)

    while q:
        pos, cost = q.popleft()
        if (n, n) in pos:
            return cost
        for next_pos in get_next_pos(pos, arr):
            if next_pos not in visited:
                q.append((next_pos, cost+1))
                visited.append(next_pos)
    return 0

print(solution([[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]))