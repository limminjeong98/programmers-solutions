answer = int(1e9)
def solution(begin, target, words):
    global answer
    wdict = {}
    for word in words:
        wdict[word] = False
    if not target in words:
        return 0
    n = len(begin)
    
    def dfs(rst, tmp, target):
        global answer
        if tmp == target:
            answer = min(answer, rst)
            return
        wdict[tmp] = True
        for word in words:
            cnt = 0
            for i in range(n):
                if tmp[i] != word[i]:
                    cnt += 1
            if cnt > 1:
                continue
            elif cnt == 1:
                if not wdict[word]:
                    dfs(rst+1, word, target)
                    
    dfs(0, begin, target)
    return answer