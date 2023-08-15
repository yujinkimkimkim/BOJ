import sys
input = sys.stdin.readline

row, col = map(int,input().split())
arr = [list(input()) for _ in range(row)]
k = int(input())

ans = 0
for i in arr:
    z = i.count('0')
    m = 0
    if z <= k and z % 2 == k % 2:
        for j in arr:
            if i == j:
                m += 1
    ans = max(ans, m)
print(ans)