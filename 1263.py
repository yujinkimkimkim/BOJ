import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    a, b = map(int, input().split())
    arr.append((a,b))
arr = sorted(arr, key=lambda x: (-x[1]))

ans = arr[0][1] - arr[0][0]
arr.remove((arr[0][0], arr[0][1]))

for item in arr:
    if ans > item[1]:
        ans = item[1] - item[0]
    else:
        ans -= item[0]

print(ans) if ans >= 0 else print(-1)