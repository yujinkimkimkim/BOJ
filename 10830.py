import sys
input = sys.stdin.readline

n, b = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

def matrix_multiply(A, B):
    n = len(A)
    result = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += A[i][k] * B[k][j] % 1000
    return result

def matrix_power(A, exp):
    if exp == 1:
        return A
    if exp % 2 == 0:
        half = matrix_power(A, exp // 2)
        return matrix_multiply(half, half)
    else:
        half = matrix_power(A, (exp - 1) // 2)
        return matrix_multiply(matrix_multiply(half, half), A)

result = matrix_power(arr, b)

for row in result:
    print(*row)
