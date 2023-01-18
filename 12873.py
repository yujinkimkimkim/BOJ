player = int(input())

playerList = []

for i in range(1, player+1):
    playerList.append(i)

cnt = 0
start = 0
removeNum = 0
for i in range(1,player): #N-1 round 해야함
    cnt = (i ** 3) % len(playerList)

    removeNum = (start + cnt - 1) % len(playerList)
    if removeNum < 0:
        removeNum += len(playerList)
    playerList.pop(removeNum)
    start = removeNum

print(playerList[0]) 