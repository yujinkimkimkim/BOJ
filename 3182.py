def dfs(node, cnt):
    check[node] = 1
    n = graph[node][0]
    if check[n] == 0:
        cnt = dfs(n, cnt+1)
    return cnt

n = int(input())
graph = [[] for _ in range(n+1)]
ans = [0]*(n+1)
for i in range(1, n+1):
    v = int(input())
    graph[i].append(v)
for i in range(1, n+1):
    check = [0]*(n+1)
    ans[i] = dfs(i, 1)
print(ans.index(max(ans)))