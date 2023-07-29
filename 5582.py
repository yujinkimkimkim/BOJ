import sys
input = sys.stdin.readline

Aarr = list(input().strip())
Barr = list(input().strip())

aLen = len(Aarr)
bLen = len(Barr)

dp = [[0 for _ in range(bLen+1)]for _ in range(aLen+1)]
ans = 0

for i in range(aLen):
    for j in range(bLen):
        if Aarr[i] == Barr[j]:
            dp[i+1][j+1] = dp[i][j] + 1
            ans = max(dp[i+1][j+1], ans)

print(ans)
