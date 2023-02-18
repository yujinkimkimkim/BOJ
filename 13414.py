import sys

input = sys.stdin.readline

k, l = map(int, input().split())
arr = dict()

for i in range(l):
    arr[input().rstrip()] = i

result = dict(sorted(arr.items(), key=lambda x:x[1]))

if (k > len(result)):
    k = len(result)

cnt = 0
for i in result.keys():
    if cnt == k:
        break
    print(i)
    cnt += 1