def solution(table, languages, preference):
    answer = ''
    arr = []
    n = len(table)
    m = len(languages)
    tmp = [[] for _ in range(n)]
    for i in range(n):
        table_str = table[i].split(' ')
        table_arr = table_str[1:]
        tmp[i] = [table_str[0], table_arr]
    # print(tmp)
    for i in range(n):
        total = 0
        for k in range(len(preference)):
            if languages[k] in tmp[i][1]:
                now = tmp[i][1].index(languages[k])
                total += preference[k] * (5-now)
        arr.append((total, tmp[i][0]))
    arr.sort(key=lambda x: (-x[0], x[1]))
    answer = arr[0][1]                           
    return answer