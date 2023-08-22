import bisect
import itertools
import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))

left, right = arr[:n//2], arr[n//2:]
tmpleft, tmpright = [], []

for i in range(1, len(left)+1):
    tmp = itertools.combinations(left, i)
    for j in tmp:
        tmpleft.append(sum(j))
tmpleft.sort()

for i in range(1, len(right)+1):
    tmp = itertools.combinations(right, i)
    for j in tmp:
        tmpright.append(sum(j))
tmpright.sort()

ans = 0
for i in tmpleft:
    t = s - i
    ans += bisect.bisect_right(tmpright, t) - bisect.bisect_left(tmpright, t)

ans += bisect.bisect_right(tmpright, s) - bisect.bisect_left(tmpright, s)
ans += bisect.bisect_right(tmpleft, s) - bisect.bisect_left(tmpleft, s)
print(ans)