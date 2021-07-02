def solution(clothes):
    answer = 0
    total = len(clothes)
    # face, headgear, eyewear, outwear = 0, 0, 0, 0
    kindOfItems = {}
    for item in clothes:
        if item[1] not in kindOfItems:
            kindOfItems[item[1]] = 1
        else:
            kindOfItems.update({item[1]: kindOfItems[item[1]]+1})
    mul = 1
    realmul = 1
#     모든 원소의 종류를 곱했을 때
    for kind, kindnum in kindOfItems.items():
        mul *= kindnum
        realmul *= kindnum + 1
        
    if mul == 1 or len(kindOfItems.keys()) == 1: 
        mul = 0
#         모든 원소를 고려하되 착용하지 않는 경우도 포함하고 -1
    # else:
    answer = realmul-1
    return answer