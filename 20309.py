n = int(input())

arr = []
arr = list(map(int,input().split()))

check = True
for i in range(1,n+1):
    if i % 2 == 1:
        if arr[i-1] % 2 != 1:
            check = False
    if i % 2 == 0:
        if arr[i-1] % 2 != 0:
            check = False
if check == False:
    print('NO')
else:
    print('YES')
