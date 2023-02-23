n, m = map(int,input().split())

def is_prime(n):
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:  # n이 i로 나누어 떨어지면 소수가 아님
            D[n] = D[n//i] + 1
            return False
    D[n] = 1
    return True

D = [0] *(m+1)
res = [False]*(m+1)
for i in range(2, m+1):
    res[i] = is_prime(i)

ans = 0
for i in range(n, m+1):
    ans += res[D[i]]
print(ans)