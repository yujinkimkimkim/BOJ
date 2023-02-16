import sys
input = sys.stdin.readline().rstrip

num = int(input())
n = list(map(int,str(num)))

arr = []
a = n[:]
for k in range(len(n)):
    for i in range(len(n)):
        for j in range(len(n)):
            a[i], a[j] = a[j], a[i]
            result = ''.join(map(str, a))
            if not int(result) in arr:
                arr.append(int(result))

arr.sort()
for i in arr:
    if num < i:
        print(i)
        break
    elif i == arr[-1]:
        print(0)
        break
