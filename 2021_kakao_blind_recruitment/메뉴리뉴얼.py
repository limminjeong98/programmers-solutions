from itertools import combinations
from collections import defaultdict
def solution(orders, course):
    answer = []
    menu_dict = defaultdict(list)
    for num in course:
        menu_dict[num] = defaultdict(list)
    for order in orders:
        for num in course:
            if num > len(order):
                break
            for case in combinations(order, num):
                case = list(case)
                case.sort()
                case = ''.join(case)
                if case not in menu_dict[num]:
                    menu_dict[num][case] = 1
                else:
                    menu_dict[num][case] += 1
    for num in course:
        tmpmax = -1
        if menu_dict[num]:
            tmpmax = max(menu_dict[num].values())
            if tmpmax == 1:
                continue
            for item in menu_dict[num].keys():
                if menu_dict[num][item] == tmpmax:
                    answer.append(item)
    answer.sort()
    return answer