from collections import deque
import sys
input = sys.stdin.readline

dir = [(1,0,0),(-1,0,0),(0,1,0),(0,-1,0),(0,0,1),(0,0,-1)]

col, row, a = map(int, input().split())
graph = []
q = deque([])
for i in range(a):
    arr = []
    for j in range(row):
        arr.append(list(map(int,input().split())))
        for k in range(col):
            if arr[j][k] == 1:
                q.append((i,j,k))
    graph.append(arr)

while q:
    curZ, curR, curC = q.popleft()
    for i, j , k in dir:
        nz = curZ + k
        nr = curR + i
        nc = curC + j
        if 0 <= nz < a and 0 <= nr < row and 0 <= nc < col and graph[nz][nr][nc] == 0:
                graph[nz][nr][nc] = graph[curZ][curR][curC] + 1
                q.append((nz,nr,nc))
day = 0
for i in graph:
    for j in i:
        for k in j:
            if k==0:
                print(-1)
                exit(0)
        day = max(day,max(j))
print(day-1)