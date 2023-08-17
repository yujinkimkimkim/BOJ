import heapq
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    arr.append(tuple(map(int,input().split())))
arr.sort()

q = []

for dead, cup in arr:
    heapq.heappush(q, cup)
    print(q)
    if dead < len(q):
        heapq.heappop(q)

print(sum(q))