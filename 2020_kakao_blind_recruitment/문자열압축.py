def solution(s):
    answer = len(s)
    n = len(s)
    for step in range(1, n//2+1):
        prev = s[0:step]
        cnt = 1
        compressed = ''
        for j in range(step, n, step):
            if prev == s[j:j+step]:
                cnt += 1
            else:
                compressed += str(cnt) + prev if cnt >= 2 else prev
                prev = s[j:j+step]
                cnt = 1
        compressed += str(cnt) + prev if cnt >= 2 else prev
        answer = min(answer, len(compressed))
    return answer