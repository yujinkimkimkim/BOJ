import sys

n = int(sys.stdin.readline())

v = [[] for _ in range(n)]

for _ in range(n):
    tmp = list(map(int, sys.stdin.readline().split()))
    for i in range(1, len(tmp)-1, 2):
        v[tmp[0]-1].append([tmp[i]-1, tmp[i+1]])
        v[tmp[i]-1].append([tmp[0]-1, tmp[i+1]])

visited = [-1] * n
visited[0] = 0
def dfs(start, w):
    for neighbor, weight in v[start]:
        if visited[neighbor] == -1:
            visited[neighbor] = weight + w
            dfs(neighbor, weight+w)

dfs(0, 0)
tmp = visited.index(max(visited))

visited = [-1] * n
visited[tmp] = 0
dfs(tmp,0)
print(max(visited))
