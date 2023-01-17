import sys

input = sys.stdin.readline

N = int(input())
E = int(input())
cnt = 0
li = [0 for i in range(1,N)]

for _ in range(E):
    group = list(map(int, input().split()))
    group = group[1:]  # 0번째 인덱스는 참여자 수이므로 슬라이싱해준다.
    if 1 in group:  # 선영이가 참석했으면
        for i in group:  # cnt 라는 노래를 현재 그룹원들은 모두 알게된다.
            li[i].append(cnt)
        cnt += 1  # 다음 노래는 달라져야 하므로 cnt의 값을 증가

    else:  # 선영이가 참석하지 않았으면
        for i in range(len(group)):  # group안을 돌면서
            for key, values in li.items():
                if group[i] in values:  # 선영이의 노래를 알고있는 그룹원이 있으면
                    for k in group:  # 나머지 그룹원들에게 노래를 공유해준다.
                        if k not in li[key]:
                            li[key].add(k)
result = []
li = dict(li)
for i in range(1, N + 1):
    check = 0  # 선영이의 노래를 몇곡 알고있는가
    for key, values in li.items():
        if i in values:
            check += 1
    if check == len(li):  # 모든 노래를 다 알고있으면
        result.append(i)  # 그 참석자는 결과값에 append 해준다.
result.sort()

for i in result:
    print(i)