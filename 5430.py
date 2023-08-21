import ast
import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
for _ in range(n):
    arr = input()
    m = int(input())
    tmp = ast.literal_eval(input())
    arr2 = deque(tmp)

    flag = True
    reverse_count = 0
    for i in arr:
        if i == 'D':
            if len(arr2) == 0:
                flag = False
                break
            if reverse_count % 2 == 0:
                arr2.popleft()
            else:
                arr2.pop()
        elif i == 'R':
            reverse_count += 1

    if flag:
        if reverse_count % 2 == 1:
            arr2.reverse()
        ans = list(arr2)
        print("[",end="")
        print(*ans,sep=",",end="")
        print("]")
    else:
        print("error")
