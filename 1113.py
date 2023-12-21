from queue import Queue
import sys

r, c = map(int, sys.stdin.readline().split())
pool = [[] for _ in range(r)]
for i in range(r):
    pool[i].extend(map(int, list(sys.stdin.readline().strip())))

direction = [[1, 0], [0, 1], [0, -1], [-1, 0]]

wallQueue = Queue()
def bfs(i, j, height, visited):
    global res
    wallQueue.put([i,j])
    visited[i][j] = True
    flag = True
    cnt = 1
    while not wallQueue.empty():
        curY, curX = wallQueue.get()
        for dirX, dirY in direction:
            nextX, nextY = curX + dirX, curY + dirY
            if nextX < 0 or nextX >= c or nextY < 0 or nextY >= r:
                flag = False
                continue
            if pool[nextY][nextX] <= height and not visited[nextY][nextX]:
                visited[nextY][nextX] = True
                wallQueue.put([nextY, nextX])
                cnt +=1
    if flag:
        res += cnt

res = 0
for height in range(1, 9):
        visited = [[0] * c for _ in range(r)]
        for i in range(r):
            for j in range(c):
                if pool[i][j] <= height and not visited[i][j]:
                    bfs(i, j, height, visited)
print(res)

