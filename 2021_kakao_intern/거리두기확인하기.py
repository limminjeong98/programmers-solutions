from collections import deque

def bfs(room):
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    for i in range(5):
        for j in range(5):
            if room[i][j] == 'P':
                visited = [[False] * 5 for _ in range(5)]
                q = deque([(i, j)])
                visited[i][j] = True
                while q:
                    x, y = q.popleft()
                    for k in range(4):
                        nx, ny = x + dx[k], y + dy[k]
                        dist = abs(i-nx) + abs(j-ny)
                        if 0 <= nx < 5 and 0 <= ny < 5 and not visited[nx][ny] and room[nx][ny] != 'X' and dist <= 2:
                            if room[nx][ny] == 'P':
                                return 0
                            elif room[nx][ny] == 'O':
                                q.append((nx, ny))
                            visited[nx][ny] = True
    return 1

def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
    return answer