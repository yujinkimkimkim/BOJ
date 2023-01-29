n = int(input())

arr = ""
for i in range(n):
    x = 0
    y = 0
    a = 0
    Xans = [0]
    Yans = [0]
    arr = input()
    for j in arr:
        if j == 'F':
            if (a / 90) % 4 == 0:
                y += 1
            elif (a / 90) % 4 == 1:
                x += 1
            elif (a / 90) % 4 == 2:
                y -= 1
            elif (a / 90) % 4 == 3:
                x -= 1
        elif j == 'B':
            if (a / 90) % 4 == 0:
                y -= 1
            elif (a / 90) % 4 == 1:
                x -= 1
            elif (a / 90) % 4 == 2:
                y += 1
            elif (a / 90) % 4 == 3:
                x += 1
        elif j == 'L':
            if a == 0:
                a += 270
            else:
                a -= 90
        elif j == 'R':
            a += 90

        Xans.append(x)
        Yans.append(y)

    A = max(Xans) + abs(min(Xans))
    B = max(Yans) + abs(min(Yans))


    print(A * B)

