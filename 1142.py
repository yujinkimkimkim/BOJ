n = int(input())

arr = []
for i in range(n):
    arr.append(input())
arr.sort()

res = arr[:]
for i in range(n):
    for j in range(i+1,n):
        if arr[j].startswith(arr[i]):
            if arr[i] in res:
                res.remove(arr[i])
        break
print(len(res))
