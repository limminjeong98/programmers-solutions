def find_parent(parents, x):
    if parents[x] != x:
        parents[x] = find_parent(parents, parents[x])
    return parents[x]

def union(parents, a, b):
    a = find_parent(parents, a)
    b = find_parent(parents, b)
    if a < b:
        parents[b] = a
    else:
        parents[a] = b
    
        
def solution(n, costs):
    parents = [0] * (n+1)
    for i in range(n+1):
        parents[i] = i
    costs.sort(key=lambda x: x[2])
    answer = 0
    for i in costs:
        a, b, cost = i
        if find_parent(parents, a) != find_parent(parents, b):
            union(parents, a, b)
            answer += cost
    
    return answer