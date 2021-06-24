from collections import deque
def solution(n, t, m, p):
    answer = ''
    if n <= 10:
        arr = list(map(str, list(range(n))))
    else:
        arr = list(map(str, list(range(10))))
    alpha = deque(['A', 'B', 'C', 'D', 'E', 'F'])
    tmp = n
    while tmp > 10:
        arr.append(alpha.popleft())
        tmp -= 1
    for i in range(t*m):
        val = i
        tmpstr = ''
        while val // n != 0:
            if val % n < t:
                tmpstr += str(arr[val % n])
            val //= n
        tmpstr += str(arr[val % n])
        answer += tmpstr[::-1]
    answer = answer[p-1::m]
    answer = answer[:t]
    return answer