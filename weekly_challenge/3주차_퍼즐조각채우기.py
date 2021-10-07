from collections import deque
import copy

global answer, empty, block

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, n, visited, array, check):
    space = []
    q = deque()
    q.append((x, y))
    space.append((x, y))
    visited[x][y] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and array[nx][ny] == check:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    space.append((nx, ny))

    return sorted(space)


def rotate(b, n):
    new_board = []
    for block in b:
        new_board.append((block[1], n - 1 - block[0]))

    return sorted(standard(new_board, n))

def standard(b, n):
    change = []
    minx, miny = n, n

    for i in b:
        minx = min(minx, i[0])
        miny = min(miny, i[1])

    for x, y in b:
        change.append((x - minx, y - miny))

    return sorted(change)

def solution(game_board, table):
    global answer, empty, block
    answer = 0
    empty = []
    block = []
    n = len(game_board)

    visited_g = [[False] * n for _ in range(n)]
    visited_t = [[False] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if game_board[i][j] == 0 and not visited_g[i][j]:
                empty.append(bfs(i, j, n, visited_g, game_board, 0))
            if table[i][j] == 1 and not visited_t[i][j]:
                block.append(bfs(i, j, n, visited_t, table, 1))
            else:
                continue

    table_block = []
    for a in block:
        table_block.append(standard(a, n))

    game_block = []
    for b in empty:
        game_block.append(standard(b, n))

    for g in game_block:
        if g in table_block:
            answer += len(g)
            table_block.remove(g)
        else:
            flag = False
            for t in table_block:
                tmp = copy.deepcopy(t)
                for _ in range(4):
                    if g == tmp:
                        answer += len(g)
                        table_block.remove(t)
                        flag = True
                        break
                    tmp = rotate(tmp, n)
                if flag:
                    break
    return answer

# 14
print(solution([[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]], [[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]))

# 0
print(solution([[0,0,0],[1,1,0],[1,1,1]], [[1,1,1],[1,0,0],[0,0,0]]))