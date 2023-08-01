import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))

cnt = 0
arr.sort()

for i in range(n):
    temp = arr[:i] + arr[i+1:]
    left, right = 0, n - 2
    while left < right:
        s = temp[left] + temp[right]
        if s == arr[i]:
            cnt += 1
            break
        elif s < arr[i]:
            left += 1
        else:
            right -= 1
print(cnt)