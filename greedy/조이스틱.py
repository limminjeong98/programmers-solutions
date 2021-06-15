def solution(name):
    answer = 0
    min_diff = [min(ord(i)-ord('A'), ord('Z')-ord(i)+1) for i in name]
    idx = 0
    while True:
        answer += min_diff[idx]
        min_diff[idx] = 0
        if sum(min_diff) == 0:
            break
        left, right = 1, 1
        while min_diff[idx - left] == 0:
            left += 1
        while min_diff[idx + right] == 0:
            right += 1
        if left < right:
            answer += left
            idx -= left
        else:
            answer += right
            idx += right
    return answer