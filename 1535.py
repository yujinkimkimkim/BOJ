n = int(input())

a = list(map(int,input().split()))
a2 = list(map(int,input().split()))

arr = []
for i in range(n):
    arr.append((a2[i],a[i]))
arr = sorted(arr, key=lambda x:x[1])
#key에 기쁨, value에 체력

for k in a:
    if k < 100:
        Llist = [row[1] for row in arr]  # 리스트에 체력 넣기
        Jlist = [row[0] for row in arr]

        res = []
        for i in range(n):
            temp = 0
            s = 100
            for j in range(len(Llist)):
                s -= Llist[j]
                if s <= 0:
                    x = Jlist.index(min(Jlist))
                    Jlist.pop(x)
                    Llist.pop(x)
                    break
                res.append(sum(Jlist[:j + 1]))

        print(max(res))
        break
else:
    print(0)