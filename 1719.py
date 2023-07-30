import sys
input = sys.stdin.readline

n, m = map(int,input().split())
INF = int(1e9)
dist = [[INF] * (n+1) for _ in range(n+1)]
node = [[i for i in range(n+1)]for _ in range(n+1)]

for i in range(1, n+1):
    dist[i][i] = 0
    node[i][i] = "-"

for i in range(m):
    s, e, c = map(int,input().split())
    dist[s][e] = min(dist[s][e], c)
    dist[e][s] = min(dist[e][s], c)

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k]+dist[k][j]
                node[i][j] = node[i][k]

for i in range(1, n+1):
    for j in range(1, n+1):
        print(node[i][j], end = " ")
    print()