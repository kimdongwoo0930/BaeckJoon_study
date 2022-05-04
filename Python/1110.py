X = input()

fisrt = X
cnt = 0

if int(X) < 10:
    X = "0" + X
while True:
    number = int(X[0]) + int(X[1])
    if number < 10:
        number = "0" + str(number)
    X = X[1] + str(number)[1]
    cnt += 1
    if int(X) == int(fisrt):
        break

print(cnt)