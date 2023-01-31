n = int(input())

for i in range(n):
    m = int(input())
    N = m
    ans = [0] * 100000
    for j in range(2,m+1):
        while m % j == 0:
            m = m / j
            ans[j] += 1

    for j in range(2, N+1):
        if ans[j]:
            print(j,'', ans[j])
