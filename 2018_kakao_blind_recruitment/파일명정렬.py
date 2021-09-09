def solution(files):
    answer = []
    length = len(files)
    for i in range(length):
        tmp_len = len(files[i])
        j, num_start_idx, num_end_idx = 0, 0, tmp_len
        found_number = False
        while j < tmp_len:
            if files[i][j].isnumeric() and not found_number:
                num_start_idx = j
                found_number = True
            if not files[i][j].isnumeric() and found_number:
                num_end_idx = j
                break
            j += 1
        if num_end_idx - num_start_idx > 5:
            num_end_idx = num_start_idx + 5
        head = files[i][:num_start_idx]
        number = files[i][num_start_idx:num_end_idx]
        tail = files[i][num_end_idx:]
        if tail == None:
            tail = ''
        print(head, number, tail)
        files[i] = [files[i], head, number, tail]
    files.sort(key=lambda x: (x[1].lower(), int(x[2])))
    for i in range(length):
        answer.append(files[i][0])
    return answer