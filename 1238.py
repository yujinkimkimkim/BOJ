import sys
import heapq
input = sys.stdin.readline
n, m, x = map(int,input().split())

INF = int(1e9) #10억
arr = [[INF for j in range(n+1)] for i in range(n+1)]
graph = [[] for i in range(n+1)]
for i in range(1,m+1):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))
x

def dijkstra(start, end):
    q = []
    heapq.heappush(q, (0, start))
    distance = [INF] * (n+1)
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance[end]

sum = 0
for i in range(1, n+1):
    a = dijkstra(i, x)
    b = dijkstra(x, i)
    sum = max(sum, a + b)

print(sum)
