from operator import add, sub, mul, floordiv 
from typing import Tuple, List, Union
from math import sin, cos

OP_FUNC = {
    '+': add,
    '-': sub,
    '*': mul,
    '/': floordiv,
    "sin": sin,
    "cos": cos
}

PRIORITY_MAP = {
    '#': 0,
    '+': 1,
    '-': 1,
    '*': 2,
    '/': 2
}

def parse_num(s: str, i: int) -> Tuple[int]: # 进制式解析数字
    num = 0
    while s[i].isnumeric():
        num = 10*num + int(s[i])
        i += 1
    return num, i

def parse_func(s, i): # 获得函数名称，作为一元运算符
    j = i+1
    while s[j].islower():
        j += 1
    return s[i:j], j 

def cal(nums: List[int], ops: List[str]) -> None:
    op = ops.pop() # 取出操作符
    if EXPECTED_ARGS[op] == 1:
        num = nums.pop()
        res = OP_FUNC[op](num)
        nums.append(res)
    elif EXPECTED_ARGS[op] == 2:
        # 取出参与计算的两个数字
        num2, num1 = nums.pop(), nums.pop()
        res = OP_FUNC[op](num1, num2) # 根据操作符调用对应的运算函数
        nums.append(res)

def eval_tokens(tokens: List):
    print(tokens)
    tokens.append('#')  # '#'的优先级最低，用以保证'#'之前的计算全部完成
    i = 0
    nums, ops = [], []
    for elem in tokens:
        if elem not in PRIORITY_MAP:
            nums.append(elem)
        else:
            # 操作符的单调栈（栈内操作符优先级递增）
            while ops and PRIORITY_MAP[ops[-1]] >= PRIORITY_MAP[elem]:
                cal(nums, ops)
            ops.append(elem)
    return nums.pop()

def parse_expr(s: str, i: int) -> int:
    tokens = []
    if s[i] == '-': 
        tokens = [0] # 如果当前表达式第一个数是负数，通过加0，表达式就转换为了正数的计算
    while s[i] != ')': 
        if s[i] == '(': # 解括号，将问题转换为不含括号的表达式
            i += 1 # 吃掉 '('
            elem, i = parse_expr(s, i)
            i += 1 # 吃掉 ')'
        elif s[i].isnumeric():
            elem, i = parse_num(s, i)
        elif s[i].islower(): # 检查函数
            op, i = parse_func(s, i)
            i += 1 # '('
            num, i = parse_expr(s, i)
            i += 1 # ')'
            elem = OP_FUNC[op](num)
        else:
            elem = s[i]
            i += 1 # 吃掉运算符
        tokens.append(elem)
    return eval_tokens(tokens), i # 解括号后 计算子表达式的值

def calculate(s: str) -> int:
    s = s.replace(' ', '') + ')' # 通过补')'可以合并条件判断，从而不用写i < len(s)
    return parse_expr(s, 0)[0]
