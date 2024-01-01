import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]

def dist(A1, A2, B1, B2):
    visited = [[False]*(N+1) for _ in range(M+1)]
    path = [[(0,0)]*(N+1) for _ in range(M+1)]
    visited[B1[0]][B1[1]] = True
    visited[B2[0]][B2[1]] = True
    tmp = bfs(A1[0], A1[1], A2[0], A2[1], visited, path)

    visited = [[False] * (N + 1) for _ in range(M + 1)]
    tmpY, tmpX = A2[0], A2[1]
    while True:
        visited[tmpY][tmpX] = True
        if tmpY == A1[0] and tmpX == A1[1]:
            break
        tmpY, tmpX = path[tmpY][tmpX]
    tmp += bfs(B1[0], B1[1], B2[0], B2[1], visited, path)
    return tmp

def bfs(y1, x1, y2, x2, visited, path):
    q = deque()
    q.append((y1, x1, 0))
    visited[y1][x1] = True
    while q:
        curY, curX, cnt = q.popleft()
        if curX == x2 and curY == y2:
            return cnt
        for i, j in directions:
            nextY, nextX = curY + i, curX + j
            if 0 <= nextY <= M and 0 <= nextX <= N and not visited[nextY][nextX]:
                q.append((nextY, nextX, cnt + 1))
                visited[nextY][nextX] = True
                path[nextY][nextX] = (curY, curX)
    return 1e9

node = []
for i in range(4):
    col, row = map(int, sys.stdin.readline().split())
    node.append([row, col])

ans = dist(node[0], node[1], node[2], node[3])
ans = min(ans, dist(node[2], node[3], node[0], node[1]))

if ans >= 1e9:
    print('IMPOSSIBLE')
else:
    print(ans)
