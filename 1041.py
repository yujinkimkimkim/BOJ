import sys
input = sys.stdin.readline

n = int(input())
dice = list(map(int,input().split()))

ans = 0
arr = []
if n == 1:
    dice.sort()
    for i in range(5):
        ans += dice[i]
else:
    arr.append(min(dice[0], dice[5]))
    arr.append(min(dice[1], dice[4]))
    arr.append(min(dice[2], dice[3]))
    arr.sort()

    d1 = arr[0]
    d2 = arr[0] + arr[1]
    d3 = arr[0] + arr[1] + arr[2]

    ans += d1 * (n - 2) * (n - 2) + d1 * (n - 1) * (n - 2) * 4
    ans += d2 * 4 * (n - 2) + d2 * 4 * (n - 1)
    ans += d3 * 4
print(ans)