import sys
from bisect import bisect_left

n = int(sys.stdin.readline())
inputList = list(map(int, sys.stdin.readline().split()))

tmp = list()
for i in range(n):
    if len(tmp) == 0:
        tmp.append(inputList[i])
    elif tmp[-1] <= inputList[i]:
        tmp.append(inputList[i])
    else:
        idx = bisect_left(tmp, inputList[i])
        tmp[idx] = inputList[i]

print(n - len(tmp))
