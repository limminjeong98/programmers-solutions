def solution(board, moves):
    answer = 0
    bucket = []
    n = len(board)
    for m in moves:
        for r in range(n):
            if board[r][m-1] != 0:
                bucket.append(board[r][m-1])
                board[r][m-1] = 0
                while len(bucket) >= 2:
                    if bucket[-1] == bucket[-2]:
                        bucket.pop()
                        bucket.pop()
                        answer += 2
                    else:
                        break
                break
    return answer