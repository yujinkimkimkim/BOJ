import sys
from itertools import combinations

n = int(sys.stdin.readline())

res = list()
for i in range(1, 11):
    for comb in combinations(range(0, 10), i):
        comb = list(comb)
        comb.sort(reverse=True)
        res.append(int("".join(map(str, comb))))
    if n < len(res):
        break
res.sort()
print(res)
try:
    print(res[n - 1])
except:
    print(-1)