import sys
import heapq

n, k = map(int, input().split())

jewelrys = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
bags = [int(sys.stdin.readline()) for _ in range(k)]
jewelrys.sort()
bags.sort()

res = 0
tmp = []

for bag in bags:
    while jewelrys and bag >= jewelrys[0][0]:
        heapq.heappush(tmp, -jewelrys[0][1])
        heapq.heappop(jewelrys)
    if tmp:
        res += heapq.heappop(tmp)
    elif not jewelrys:
        break

print(-res)