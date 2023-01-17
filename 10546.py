import sys
num = int(sys.stdin.readline().rstrip())
nameList = dict()
for _ in range(num*2 - 1):
    name = sys.stdin.readline().rstrip()
    if name not in nameList.keys():
        nameList[name] = 1
    elif name in nameList.keys() and nameList[name] == 0:
        nameList[name] = 1
    else:
        nameList[name] = 0

for key, value in nameList.items():
    if value == 1:
        print(key)
        break