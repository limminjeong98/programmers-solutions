def solution(numbers, hand):
    answer = ''
    preL, preR = (3,0), (3,2)
    for n in numbers:
        if n == 0:
            disL = abs(3-preL[0]) + abs(1-preL[1])
            disR = abs(3-preR[0]) + abs(1-preR[1])
            if disL < disR:
                answer += 'L'
                preL = (3, 1)
            elif disR < disL:
                answer += 'R'
                preR = (3, 1)
            else:
                if hand == 'left':
                    answer += 'L'
                    preL = (3, 1)
                else:
                    answer += 'R'
                    preR = (3, 1)
        elif n % 3 == 1:
            answer += 'L'
            preL = (n // 3, 0)
        elif n % 3 == 0:
            answer += 'R'
            preR = (n // 3 - 1, 0)
        elif n % 3 == 2:
            disL = abs(n // 3 - preL[0]) + abs(1 - preL[1])
            disR = abs(n // 3 - preR[0]) + abs(1 - preR[1])
            
            if disL < disR:
                answer += 'L'
                preL = (n // 3, 1)
            elif disR < disL:
                answer += 'R'
                preR = (n // 3, 1)
            else:
                if hand == 'left':
                    answer += 'L'
                    preL = (n // 3, 1)
                else:
                    answer += 'R'
                    preR = (n // 3, 1)
                    
    return answer