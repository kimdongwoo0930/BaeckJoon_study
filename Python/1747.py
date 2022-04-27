'''
1747

어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.

어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오
'''

N = int(input())
result = 0


def prime_number(num):
    for j in range(2, N):
        if num % j == 0:
            return False
    return True


for i in range(N, 1000001):
    if i == 1:
        continue
    if str(i)[::] == str(i)[::-1]:
        if prime_number(i):
            result = i
            print(result)
            break

if result == 0:
    print(1003001)
