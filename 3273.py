import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
x = int(input())
arr.sort()

fp=0
ep=len(arr)-1
ans = 0

while fp != ep:
    if arr[fp] + arr[ep] == x:
        ep -= 1
        ans += 1
    else:
        if arr[fp] + arr[ep] < x:
            fp += 1
        else:
            ep -= 1
print(ans)