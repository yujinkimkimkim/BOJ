import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
graph = [[]for _ in range(n+1)]

def dijkstra(start, end):
    q = []
    heapq.heappush(q, (0, start))
    dist = [INF for _ in range(n+1)]
    dist[start] = 0

    while q:
        d, now = heapq.heappop(q)
        if dist[now] < d:
            continue
        for i in graph[now]:
            tmp = d + i[1]
            if tmp < dist[i[0]]:
                dist[i[0]] = tmp
                heapq.heappush(q, (tmp, i[0]))
    return dist[end]

for i in range(m):
    s, e, c = map(int,input().split())
    graph[s].append((e, c))
    graph[e].append((s, c))

ans = dijkstra(1, n)
print(ans)