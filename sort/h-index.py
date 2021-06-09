def solution(citations):
    answer = 0
    n = len(citations)
    arr = [0] * (n+1)
    for c in range(n):
        now = citations[c]
        if now > n:
            now = n
        while now > 0:
            arr[now] += 1
            now -= 1
    for i in range(1, n+1):
        if arr[i] >= i:
            answer = max(answer, i)
    return answer