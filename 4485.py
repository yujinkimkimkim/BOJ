import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)
dir = [(1,0),(-1,0),(0,1),(0,-1)]

def dijkstra():
    q = []
    heapq.heappush(q, (node[0][0], 0, 0))
    cost[0][0] = node[0][0]

    while q:
        c, curX, curY = heapq.heappop(q)
        if cost[curY][curX] < c:
            continue
        for i, j in dir:
            nx = curX + i
            ny = curY + j
            if 0 <= nx < n and 0 <= ny < n:
                temp = c + node[ny][nx]
                if cost[ny][nx] > temp:
                    cost[ny][nx] = temp
                    heapq.heappush(q,(temp, nx, ny))

cnt = 0
while True:
    cnt += 1
    n = int(input())
    if n == 0:
        break
    node = [list(map(int,input().split())) for _ in range(n)]
    cost = [[INF for _ in range(n)]for _ in range(n)]
    dijkstra()
    print("Problem ",cnt,": ",cost[n-1][n-1],sep='')
