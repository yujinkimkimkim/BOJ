import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    arr.append(int(input()))

check = False
arr = sorted(arr, reverse=True)
idx = 0
for i in range(idx + 1, n - 1):
    a = arr[idx]

    for j in range(idx + 2, n):
        if arr[i] + arr[j] > a:
            print(arr[i]+arr[j]+a)
            check = True
            break

    if check:
        break
    idx += 1
else:
    print(-1)