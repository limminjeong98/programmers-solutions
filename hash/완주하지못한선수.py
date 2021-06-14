def solution(participant, completion):
    answer = ''
    num = len(participant)
    participant.sort()
    completion.sort()
    for index in range(num-1):
        if participant[index] != completion[index]:
            answer = participant[index]
            return answer
    answer = participant[num-1]
    return answer