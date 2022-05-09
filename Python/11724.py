import sys
sys.setrecursionlimit(10000)

N, M = map(int, sys.stdin.readline().split())

Map = [[]*(N+1) for _ in range(N+1)]
visit = [0]*(N+1)
count = 0


for _ in range(0, M):
    x, y = map(int, sys.stdin.readline().split())
    Map[x].append(y)
    Map[y].append(x)


def dfs(start):
    visit[start] = 1
    for i in Map[start]:
        if visit[i] == 0:
            dfs(i)


for i in range(1, N+1):
    if visit[i] == 0:
        dfs(i)
        count += 1

print(count)

# input 말고 import sys.stdin.readline()으로 입력받을것 input으로 하면 시간초과뜸.

# sys.setrecursionlimit(10000) 파이썬은 자체 재귀함수를 돌리면 수가 제한이 있기때문에 직접 늘려줘야한다.