def solution(record):
    answer = []
    user_dict = {}
    n = len(record)
    for i in range(n):
        job = record[i].split()[0]
        if job == 'Enter':
            job, userid, username = record[i].split()
            answer.append(userid+'님이 들어왔습니다.')
            user_dict[userid] = username
        elif job == 'Leave':
            job, userid = record[i].split()
            answer.append(userid+'님이 나갔습니다.')
        else:
            job, userid, username = record[i].split()
            user_dict[userid] = username
    la = len(answer)        
    for i in range(la):
        ididx = answer[i].find('님')
        tmp = user_dict[answer[i][:ididx]] + answer[i][ididx:]
        answer[i] = tmp
    return answer