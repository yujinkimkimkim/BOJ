import math
import sys
input = sys.stdin.readline

n = int(input())
l = int(input())
c = int(input())

num = (int)(math.ceil(c-l)/(l+1)) + 1

if num % 13 == 0:
    num -= 1
elif n < num:
    if n % 13 == 0:
        print(2)
    else:
        print(1)
    sys.exit()
if n % num == 0:
    print(n // num)
elif n % num != 0:
    print((n // num) +1)