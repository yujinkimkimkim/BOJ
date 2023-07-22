import sys
import heapq
input = sys.stdin.readline

M, N = map(int, input().split())

arr = []

for i in range(N):
    arr.append(list(map(int,input().rstrip())))

cnt = [[1e9 for i in range(M)] for j in range(N)]

def dijkstra(x, y):
    q = []
    cnt[x][y] = 0
    heapq.heappush(q, (0, x, y))

    dir = [(1,0),(-1,0),(0,1),(0,-1)]
    while q:
        cost, curX, curY = heapq.heappop(q)
        if curX == N-1 and curY == M-1:
            continue
        for i, j in dir:
            nx = curX + i
            ny = curY + j
            if 0 <= nx < N and 0 <= ny < M:
                if cnt[nx][ny] == 1e9:
                    temp  = cost
                    if arr[nx][ny] == 1:
                        temp += 1
                    cnt[nx][ny] = temp
                    heapq.heappush(q, (temp, nx, ny))



dijkstra(0,0)
print(cnt[-1][-1])