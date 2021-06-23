from copy import deepcopy
def check(m, n, board):
    cnt = 0
    new_board = deepcopy(board)
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j].isalpha():
                if board[i][j] == board[i][j+1] == board[i+1][j] == board[i+1][j+1]:
                    new_board[i][j] = new_board[i][j+1] = new_board[i+1][j] = new_board[i+1][j+1] = '-1'
    for i in range(m):
        for j in range(n):
            if new_board[i][j] == '-1':
                cnt += 1
    if cnt == 0:
        return False, 0
    return new_board, cnt

def down(m, n, board):
    for i in range(m-1, 0, -1):
        for j in range(n):
            if not board[i][j].isalpha():
                for k in range(i-1, -1, -1):
                    if board[k][j].isalpha():
                        board[i][j] = board[k][j]
                        board[k][j] = '-1'
                        break
    for i in range(m):
        for j in range(n):
            if board[i][j] == '-1':
                board[i][j] = '0'            
    return board
    
def solution(m, n, board):
    answer = 0
    for i in range(m):
        board[i] = list(board[i])
    while True:
        board, cnt = check(m, n, board)
        answer += cnt
        if not board:
            break
        board = down(m, n, board)
    return answer