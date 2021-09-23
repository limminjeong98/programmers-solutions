def solution(numbers):
    answer = []
    n = len(numbers)
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if numbers[i] + numbers[j] in answer:
                continue
            answer.append(numbers[i] + numbers[j])
    answer.sort()
    return answer