import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
node = [list(map(int, input().split()))for _ in range(n)]
parent = [i for i in range(n+1)]
arr = list(map(int, input().split()))

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x, y = find(x), find(y)
    if x > y:
        parent[x] = y
    else:
        parent[y] = x

for i in range(n):
    for j in range(n):
        if node[i][j]:
            union(i+1, j+1)

ans = "YES"
for i in range(1, m):
    if parent[arr[i]] != parent[arr[0]]:
        ans = "NO"
        break

print(ans)