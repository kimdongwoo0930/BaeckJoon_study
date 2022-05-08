N, M = map(int, input().split())

Num = []
List = []
F = 0
L = 0

for _ in range(M):
    Num.append(list(map(int, input().split())))

Num.sort(key=lambda x: x[0])
for i in range(0, M):
    L = len(List)
    F = 0
    for j in range(0, L):
        if str(Num[i][0]) in List[j]:
            if str(Num[i][1]) not in List[j]:
                List[j] += str(Num[i][1])
        else:
            F += 1
    if F == L:
        List.append(str(Num[i][0]) + str(Num[i][1]))

print(len(List))