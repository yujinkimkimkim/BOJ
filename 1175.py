import sys
from collections import deque

row, col = map(int,sys.stdin.readline().split())
board = []
start = []
for i in range(row):
    board.append(list(sys.stdin.readline().strip()))
    if 'S' in board[i]:
        start.append((i,board[i].index('S'),-1,0))

dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs(start):
    q = deque(start)
    visit = [[[1 for _ in range(col)] for _ in range(row)] for _ in range(4)]
    cNum = 0
    find = deque()
    while q :
        curRow, curCol, direction, cnt = q.popleft()
        for i in range(4):
            if i == direction :
                continue
            nextRow = curRow + dir[i][0]
            nextCol = curCol + dir[i][1]
            if 0 <= nextRow < row and 0 <= nextCol < col and board[nextRow][nextCol] != '#' and visit[i][nextRow][nextCol]:
                if board[nextRow][nextCol] == 'C' :
                    if not find :
                        cNum +=1
                        if cNum == 2:
                            return cnt+1
                    elif find[0][0] != nextRow or find[0][1] != nextCol:
                        continue
                    find.append((nextRow,nextCol,i,cnt+1))
                else :
                    if find:
                        continue
                    visit[i][nextRow][nextCol] -=1
                    q.append((nextRow,nextCol,i,cnt+1))
        if not q and find:
            visit = [[[1 for _ in range(col)] for _ in range(row)] for _ in range(4)]
            board[find[0][0]][find[0][1]] = '.'
            while find:
                q.append(find.pop())
    return -1
print(bfs(start))