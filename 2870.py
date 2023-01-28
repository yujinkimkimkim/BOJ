n = int(input())

arr = []
numArr = ['0','1','2','3','4','5','6','7','8','9']

for i in range(n):
    arr.append(input())
num = ""
ans = []

for i in arr:
    for j in i:
        if j in numArr:
            num += j
        elif num != '':
            N = int(num)
            ans.append(N)
            num = ""
    if i[-1] in numArr:
        N = int(num)
        ans.append(N)
        num = ""

ans.sort()
for i in ans:
    print(i)