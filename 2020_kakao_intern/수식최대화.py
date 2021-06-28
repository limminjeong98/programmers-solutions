from itertools import permutations
def operate(num1, num2, op):
    if op == '+':
        return str(int(num1) + int(num2))
    elif op == '-':
        return str(int(num1) - int(num2))
    elif op == '*':
        return str(int(num1) * int(num2))
    
def calculate(expression, perm):
    tmp = []
    for i in expression:
        if i not in perm:
#             숫자이고 먼저 들어간 값도 숫자라면 50, 이런 두자리의 숫자이니까 연속해서 넣어줘야함
            if len(tmp) > 0 and tmp[-1] not in perm:
                tmp[-1] = tmp[-1] + i
            else:
#                 한자리숫자라면 그냥 넣음
                tmp.append(i)
        else:
#             연산자일때
            tmp.append(i)
    
    stack = []
    result = []
    for op in perm:
        while True:
            if len(tmp) == 0:
                break
            now = tmp.pop(0)
            if now == op:
                stack.append(operate(stack.pop(-1), tmp.pop(0), op))
            else:
                stack.append(now)
        result.append(int(stack[-1]))
        tmp = stack
        stack = []
    return abs(int(result[-1]))

def solution(expression):
    answer = 0
    operators = ['+', '-', '*']
    for perm in list(permutations(operators, 3)):
        answer = max(answer, calculate(expression, perm))
    return answer