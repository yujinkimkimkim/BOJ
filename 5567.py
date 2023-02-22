n = int(input())
m = int(input())

arr = [[] for _ in range(n+1)]

for k in range(m):
    i, j = map(int,input().split())
    arr[i] += [j]
    arr[j] += [i]

res = []
for i in arr[1]:
    res.append(i)
    temp = [a for a in arr[i]]
    res += temp

if res:
    res = set(res)
    print(len(res)-1)
else:
    print(0)