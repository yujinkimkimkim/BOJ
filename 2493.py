import sys
input = sys.stdin.readline

n = int(input())
st = list(map(int,input().split()))
stack = []
ans = [0] * n
for idx, i in enumerate(st):
    while stack:
        if stack[-1][0] > i:
            ans[idx] = stack[-1][1] + 1
            break
        else:
            stack.pop()
    stack.append([i, idx])
print(*ans)