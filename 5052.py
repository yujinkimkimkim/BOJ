import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

while n != 0:
    n-=1
    check = False
    m = int(input())

    arr = deque()
    for i in range(m):
        arr.append(input().rstrip())
    arr = deque(sorted(arr, key=len))

    for idx, i in enumerate(arr):
        if idx == m-1:
            break
        for j in range(idx+1,m):
            if arr[j].startswith(i):
                check = True
                break
        if check:
            break

    if check:
        print("NO")
    else:
        print("YES")