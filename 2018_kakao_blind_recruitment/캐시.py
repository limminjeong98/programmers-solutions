from collections import deque
def solution(cacheSize, cities):
    answer = 0
    n = len(cities)
    for i in range(n):
        cities[i] = cities[i].lower()
    stack = deque([])
    idx = 0
    if cacheSize == 0:
        return n * 5
    while idx < n:
        while len(stack) < cacheSize:
            if idx == n:
                break
            if not stack:
                stack.append(cities[idx])
                idx += 1
                answer += 5
            elif stack and cities[idx] in stack:
                now = stack.index(cities[idx])
                stack = list(stack)
                stack.pop(int(now))
                stack.append(cities[idx])
                stack = deque(stack)
                idx += 1
                answer += 1
            elif stack and cities[idx] not in stack:
                stack.append(cities[idx])
                idx += 1
                answer += 5
        if stack and cities[idx] not in stack:
            stack.popleft()
            stack.append(cities[idx])
            idx += 1
            answer += 5
        elif stack and cities[idx] in stack:
            now = stack.index(cities[idx])
            stack = list(stack)
            stack.pop(int(now))
            stack.append(cities[idx])
            stack = deque(stack)
            idx += 1
            answer += 1
    return answer