N = int(input())
CH_list = []
select = 0
anw = ""

for i in range(N):
    X = input()
    X.upper()
    if len(X) > 11:
        X = X[:10]
    CH_list.append(X)

while True:
    if CH_list[0] == "KBS1" and CH_list[1] == "KBS2":
        break
    elif CH_list[0] != "KBS1":
        if CH_list[select] == "KBS1":
            tmp = CH_list[select]
            CH_list[select] = CH_list[select-1]
            CH_list[select-1] = tmp
            anw += "4"
            select -= 1
        elif CH_list[select] != "KBS1":
            select += 1
            anw += "1"
    elif CH_list[0] == "KBS1" and CH_list[1] != "KBS2":
        if CH_list[select] == "KBS2":
            tmp = CH_list[select]
            CH_list[select] = CH_list[select - 1]
            CH_list[select - 1] = tmp
            anw += "4"
            select -= 1
        elif CH_list[select] != "KBS2":
            select += 1
            anw += "1"
print(anw)