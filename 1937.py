import sys
from collections import deque
input = sys.stdin.readline

def dfs(x, y):
    if dp[x][y] != -1:
        return dp[x][y]
    dp[x][y] = 1

    for i, j in dir:
        nx = x + i
        ny = y + j
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if arr[x][y] < arr[nx][ny]:
            dp[x][y] = max(dp[x][y], dfs(nx, ny) +1)
    return dp[x][y]

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]
dp = [[-1 for _ in range(n)] for _ in range(n)]
dir = [(1, 0), (-1, 0), (0, 1), (0, -1)]

ans = 0
for i in range(n):
    for j in range(n):
        ans = max(ans, dfs(i,j))

print(ans)

