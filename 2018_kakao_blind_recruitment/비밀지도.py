def solution(n, arr1, arr2):
    answer = [[' '] * n for _ in range(n)]
    array1 = [[0] * n for _ in range(n)]
    array2 = [[0] * n for _ in range(n)]
    for i in range(n):
        binary = str(bin(arr1[i]))
        binary = list(binary[2:])
        for j in range(n-1, -1, -1):
            if binary:
                array1[i][j] = int(str(binary.pop()))
            else:
                array1[i][j] = 0
    
    for i in range(n):
        binary = str(bin(arr2[i]))
        binary = list(binary[2:])
        for j in range(n-1, -1, -1):
            if binary:
                array2[i][j] = int(str(binary.pop()))
            else:
                array2[i][j] = 0
    
    for i in range(n):
        for j in range(n):
            if array1[i][j] == 1 or array2[i][j] == 1:
                answer[i][j] = '#'
                
    for i in range(n):
        answer[i] = ''.join(map(str, answer[i]))
    return answer