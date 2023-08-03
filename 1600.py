from collections import deque

k = int(input())
m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dist = [(1,0),(-1,0),(0,1),(0,-1)]
horse = [(2, 1), (-2, 1), (2, -1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]

def bfs():
  visited = [[[0]*(k+1) for _ in range(m)] for _ in range(n)]
  queue = deque()
  queue.append([0,0,0])
  visited[0][0][0] = 1

  while queue:
    curX, curY, num = queue.popleft()

    if curX==n-1 and curY==m-1:
      return visited[curX][curY][num]-1

    for i,j in dist:
      nx, ny = curX+i, curY+j
      if 0<=nx<n and 0<=ny<m and not visited[nx][ny][num] and not graph[nx][ny]:
        visited[nx][ny][num] = visited[curX][curY][num]+1
        queue.append([nx,ny,num])

    if num<k:
      for i, j in horse:
        hx, hy = curX+i, curY+j
        if 0<=hx<n and 0<=hy<m:
          if not graph[hx][hy]:
            if not visited[hx][hy][num+1]:
              visited[hx][hy][num+1] = visited[curX][curY][num]+1
              queue.append([hx,hy,num+1])

  return -1

print(bfs())