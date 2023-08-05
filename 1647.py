import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    pa, pb = find(a), find(b)
    if pa < pb:
        parent[pb] = pa
    else:
        parent[pa] = pb

n, m = map(int, input().split())
graph = []

for i in range(m):
    a, b, cost = map(int, input().split())
    graph.append((a,b,cost))

graph = sorted(graph, key=lambda x: x[2])

parent = [i for i in range(n+1)]

ans = 0
selected = []
for a, b, cost in graph:
    if find(a) != find(b):
        union(a, b)
        ans += cost
        selected.append(cost)

print(ans - selected.pop())
