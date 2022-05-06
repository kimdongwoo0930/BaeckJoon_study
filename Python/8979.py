N, S = map(int,input().split())

con = {}
count = 1
num = 0

for i in range(0, N):
    sum = ""
    L = input().split()
    for j in range(1, 4):
        sum += L[j]
        num += int(L[j])
    con[int(L[0])] = int(sum)
if num <= 1000000:
    con = sorted(con.items())
    for i in range(0, N):
        if con[S-1][1] < con[i][1]:
            count += 1

    print(count)
