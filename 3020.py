import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

n, h = map(int, input().split())

down = []
up = []
for i in range(n):
    if i % 2 == 0:
        down.append(h - int(input()))
    else:
        up.append(int(input()))
down.sort()
up.sort()

ans = []
for i in range(1, h+1):
    temp = 0
    temp += bisect_right(down, h - i)
    temp += len(up) - bisect_right(up, h - i)
    ans.append(temp)
print(min(ans), ans.count(min(ans)))