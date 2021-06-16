answer = 0
def solution(numbers, target):
    n = len(numbers)
    def dfs(cnt, n, now, target):
        global answer
        if cnt == n:
            if now == target:
                answer += 1
            return
            
        dfs(cnt+1, n, now+numbers[cnt], target)
        dfs(cnt+1, n, now-numbers[cnt], target)
        
    dfs(1, n, numbers[0], target)
    dfs(1, n, -numbers[0], target)
            
    return answer