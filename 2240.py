import sys

input = sys.stdin.readline

t, w = map(int, input().split())
dp = [[[0 for _ in range(w+2)] for _ in range(t+1)] for _ in range(3)]

for i in range(1, t + 1):
    num = int(input())
    for j in range(1, w + 2):
        if num == 1:
            dp[1][i][j] = max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1)
            dp[2][i][j] = max(dp[1][i - 1][j - 1], dp[2][i - 1][j])
        else:
            if i == 1 and j == 1:
                continue
            dp[1][i][j] = max(dp[2][i - 1][j - 1], dp[1][i - 1][j])
            dp[2][i][j] = max(dp[1][i - 1][j - 1] + 1, dp[2][i - 1][j] + 1)

print(max(dp[1][t][w+1], dp[2][t][w+1]))
