import sys
input = sys.stdin.readline

n = int(input())

sang = []
for i in range(n):
    sang.append(int(input()))

g = []
for i in range(1, 2 * n + 1):
    if not i in sang:
        g.append(i)

sang.sort()
g.sort()

now = sang.pop(0)
r = 1 #근상이턴
while sang and g:
    if r == 1:
        for i in range(len(g)):
            if now < g[i]:
                now = g.pop(i)
                r = 2
                break
            elif i == len(g)-1:
                now = sang.pop(0)
                r = 1
    elif r == 2:
        for i in range(len(sang)):
            if now < sang[i]:
                now = sang.pop(i)
                r = 1
                break
            elif i == len(sang)-1:
                now = g.pop(0)
                r = 2

print(len(g))
print(len(sang))