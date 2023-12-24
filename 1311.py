import sys

n = int(sys.stdin.readline())
d = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[1e9 for _ in range(1 << n)] for _ in range(20)]

def dfs(cnt, visited):
    if visited == (1 << n) - 1:
        return 0
    if dp[cnt][visited] != 1e9:
        return dp[cnt][visited]
    for i in range(n):
        bit = 1 << i

        if visited & bit:
            continue
        dp[cnt][visited] = min(dfs(cnt+1, visited|bit) + d[cnt][i], dp[cnt][visited])

    return dp[cnt][visited]

print(dfs(0, 0))
