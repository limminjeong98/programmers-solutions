import re
def solution(phone_book):
    answer = True
    phone_book.sort()
    for index in range(len(phone_book)-1):
        if re.search('^' + phone_book[index], phone_book[index+1]) != None:
            answer = False
            break
    return answer