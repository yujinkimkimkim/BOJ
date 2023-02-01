n, l = map(int,input().split())

arr = []
arr = list(map(int,input().split()))
arr.sort()

cnt = 1
start = arr[0]
for i in arr[1:]:
    if i not in range(start, start + l):
        cnt += 1
        start = i
print(cnt)
