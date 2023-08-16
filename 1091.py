import sys
input = sys.stdin.readline

n = int(input())
p = list(map(int, input().split()))
s = list(map(int,input().split()))
tmp = [i for i in range(n)]
start = tmp[:]
t = tmp[:]
cnt = 0

while True:
    check = True
    print(t)
    for idx, i in enumerate(t):
        if p[i] != idx % 3:
            check = False
            break
    if check:
        break
    if t == start and cnt != 0:
        cnt = -1
        break

    for i in range(n):
        tmp[s[i]] = t[i]
    t = tmp[:]
    cnt += 1


print(cnt)

