import bisect
import sys
from collections import deque
input = sys.stdin.readline

n = input().rstrip()
a = [int(i) for i in n]
m = int(input())
arr = deque([0,1,2,3,4,5,6,7,8,9])

marr = list(map(int, input().split()))
for i in marr:
    arr.remove(i)

tmp = []
num = 0
for idx, i in enumerate(a):
    if not i in arr:
        arr.append(i)
        arr = sorted(arr)
        num = arr[arr.index(i)-1]
        print(num)
        arr.remove(i)
        tmp.append(num)
    else:
        tmp.append(i)

print(tmp)
ans = len(a)
tmp = ''.join(map(str,tmp))
ans += abs(int(n) - int(tmp))
print(ans)