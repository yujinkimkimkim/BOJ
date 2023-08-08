import sys

input = sys.stdin.readline


def dfs(node):
    if dp[node] != -1:
        return dp[node]

    time = arr2[node]
    for neighbor in arr[node]:
        time = max(time, dfs(neighbor) + arr2[node])

    dp[node] = time
    return time


n = int(input())

arr2 = [0]  # 건물을 짓는데 걸리는 시간
arr = [[] for _ in range(n + 1)]  # 건물 간의 의존 관계

for i in range(1, n + 1):
    inputLine = list(map(int, input().split()))
    t = inputLine[0]
    a = inputLine[1:-1]

    arr2.append(t)
    arr[i] = a

dp = [-1] * (n + 1)

for i in range(1, n + 1):
    ans = dfs(i)
    print(ans)
