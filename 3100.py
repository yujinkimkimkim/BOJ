import sys

rowMin = 0
colMin = 0

def row(arr1, arr2):
    arrDict = dict()
    arrMax = 0
    global rowMin
    for i in arr1:
        if i not in arrDict.keys():
            arrDict[i] = 1
        else:
            arrDict[i] += 1
    for i in arr2:
        if i not in arrDict.keys():
            arrDict[i] = 1
        else:
            arrDict[i] += 1
    for i in arrDict.values():
        arrMax = max(arrMax, i)

    for i in arrDict.values():
        if i < arrMax:
            rowMin += i
def col(arr):
    global colMin
    for l in range(3):
        arrDict = dict()
        arrMax = 0

        for i in range(6):
            for j in range(3):
                if arr[i][l*3+j] not in arrDict.keys():
                    arrDict[arr[i][l*3+j]] = 1
                else:
                    arrDict[arr[i][l*3+j]] += 1

        for i in arrDict.values():
            arrMax = max(arrMax, i)

        for i in arrDict.values():
            if i < arrMax:
                colMin += i

data = [sys.stdin.readline().strip() for i in range(6)]

for i in range(3):
    row(data[2*i],data[2*i+1])
col(data)
print(min(colMin, rowMin))
