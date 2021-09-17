from itertools import product
def solution(word):
    answer = 0
    alpha = ['A', 'E', 'I', 'O', 'U']
    arr = []
    for i in range(1,6):
        arr += list(product(alpha, repeat=i))
    arr.sort()
    # arr.sort(key=lambda x: x*5)
    for i in range(len(arr)):
        arr[i] = ''.join(arr[i])
    answer = arr.index(word)
    return answer+1