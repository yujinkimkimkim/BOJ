import sys
input = sys.stdin.readline

n = int(input())

def find(a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a, b = find(a), find(b)
    if a != b:
        parent[b] = a
        num[a] += num[b]

for i in range(n):
    m = int(input())

    parent = dict()
    num = dict()

    for j in range(m):
        a, b = map(str, input().rstrip().split())

        if not a in parent:
            parent[a] = a
            num[a] = 1
        if not b in parent:
            parent[b] = b
            num[b] = 1
        union(a, b)
        print(num[parent[a]])
