import sys
from collections import Counter
input = sys.stdin.readline().rstrip

arr = list(input())
a = Counter(arr)

arr.sort()

cnt = 0
center = ''
for i in a:
    if a[i] % 2 == 1:
        cnt += 1
        center = i
        arr.remove(i)
    if cnt > 1:
        break

if cnt > 1:
    print("I'm Sorry Hansoo")
else:
    ans = ""
    for i in range(0, len(arr), 2):
        ans += arr[i]
    print(ans + center + ans[::-1])
