# n^2 -x^2 = 15
# (n+x)(n-x) = 15
import math
import sys
input = sys.stdin.readline

n = int(input())
arr = []

check = True
for i in range(1,n):
    temp = math.pow(i,2) + n
    temp = math.sqrt(temp)
    isInt = float.is_integer(temp)
    if isInt:
        check = False
        print((int)(temp))
if check:
    print(-1)
