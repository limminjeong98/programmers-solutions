from bisect import bisect_left, bisect_right

def count_by_range(arr, left_value, right_value):
    left_index = bisect_left(arr, left_value)
    right_index = bisect_right(arr, right_value)
    return right_index - left_index

def solution(words, queries):
    answer = []
    arr = [[] for _ in range(10001)]
    reversed_arr = [[] for _ in range(10001)]

    for word in words:
        arr[len(word)].append(word)
        reversed_arr[len(word)].append(word[::-1])

    for i in range(10001):
        arr[i].sort()
        reversed_arr[i].sort()
        
    for query in queries:
        if query[0] == '?':
            cnt = count_by_range(reversed_arr[len(query)], query.replace('?', 'a')[::-1], query.replace('?', 'z')[::-1])
        else:
            cnt = count_by_range(arr[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
        answer.append(cnt)
    return answer

print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))