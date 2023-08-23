import math
import sys
input = sys.stdin.readline
n, r, g, b = map(int, input().split())

dp = [[[[0] * (b + 1) for _ in range(g + 1)] for _ in range(r + 1)] for _ in range(n + 1)]

for i in range(n + 1):
    for j in range(r + 1):
        for k in range(g + 1):
            for l in range(b + 1):
                if i == 0:
                    dp[i][j][k][l] = 1
                    continue
                if j - i >= 0:
                    dp[i][j][k][l] += dp[i - 1][j - i][k][l]
                if k - i >= 0:
                    dp[i][j][k][l] += dp[i - 1][j][k - i][l]
                if l - i >= 0:
                    dp[i][j][k][l] += dp[i - 1][j][k][l - i]

                if i % 2 == 0:
                    tmp = i // 2
                    if j - tmp >= 0 and k - tmp >= 0:
                        dp[i][j][k][l] += dp[i-1][j-tmp][k-tmp][l] * math.comb(i, tmp)
                    if k - tmp >= 0 and l - tmp >= 0:
                        dp[i][j][k][l] += dp[i-1][j][k-tmp][l-tmp] * math.comb(i, tmp)
                    if l - tmp >= 0 and j - tmp >= 0:
                        dp[i][j][k][l] += dp[i-1][j-tmp][k][l-tmp] * math.comb(i, tmp)
                if i % 3 == 0:
                    tmp = i // 3
                    if j - tmp >= 0 and k - tmp >= 0 and l - tmp >= 0:
                        dp[i][j][k][l] += dp[i-1][j-tmp][k-tmp][l-tmp] * math.comb(i, tmp) * math.comb(i-tmp, tmp)
print(dp[n][r][g][b])
