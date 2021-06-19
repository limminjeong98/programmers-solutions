def check(new_lock):
    n = len(new_lock)//3
    for i in range(n, 2*n):
        for j in range(n, 2*n):
            if new_lock[i][j] != 1:
                return False
    return True

def rotate(key):
    m = len(key)
    new_key = [[0] * m for _ in range(m)]
    for i in range(m):
        for j in range(m):
            new_key[i][j] = key[j][m-1-i]
    return new_key

def solution(key, lock):
    m = len(key)
    n = len(lock)
    large_lock = [[0] * 3 * n for _ in range(3*n)]
    for i in range(n):
        for j in range(n):
            large_lock[n+i][n+j] = lock[i][j]
    for d in range(4):
        key = rotate(key)
        for i in range(0, 2 * n):
            for j in range(0, 2 * n):
                for ii in range(m):
                    for jj in range(m):
                        large_lock[i+ii][j+jj] += key[ii][jj]
                if check(large_lock):
                    return True
                for ii in range(m):
                    for jj in range(m):
                        large_lock[i+ii][j+jj] -= key[ii][jj]
    return False