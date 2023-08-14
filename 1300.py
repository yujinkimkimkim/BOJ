import sys
input = sys.stdin.readline

size = int(input())
n = int(input())

start, end = 1, n
ans = 0

while start <= end:
    mid = (start + end)//2
    temp = 0
    for i in range(1, size + 1):
        temp += min(mid//i, size)

    if temp >= n:
        ans = mid
        end = mid - 1
    else:
         start = mid + 1
print(ans)