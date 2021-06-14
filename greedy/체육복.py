def solution(n, lost, reserve):
    res = set(reserve) - set(lost)
    los = set(lost) - set(reserve)
    for r in res:
        if r-1 in los:
            los.remove(r-1)
        elif r+1 in los:
            los.remove(r+1)
    
    return n-len(los)