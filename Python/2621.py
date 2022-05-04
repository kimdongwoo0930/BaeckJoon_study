'''
근우는 오늘 재미있는 카드 게임을 배우고 있다. 카드는 빨간색, 파란색, 노란색, 녹색의 네 가지 색이 있고, 색깔별로 1부터 9까지 숫자가 쓰여진 카드가 9장씩 있다. 카드는 모두 36(=4x9)장이다. 근우가 배운 카드 게임은 36장의 카드에서 5장을 뽑고, 아래와 같은 규칙으로 정수를 계산하는 것이다.

각 카드는 다음과 같이 나타낸다. 카드의 색깔은 영어 대문자 R, B, Y, G로 나타내는데, R은 빨간색, B는 파란색, Y는 노란색, G는 녹색을 뜻한다. 예를 들어서 Y8은 노란색 8을 나타내고, B5는 파란색 5를 나타낸다.

<점수를 정하는 규칙>

카드 5장이 모두 같은 색이면서 숫자가 연속적일 때, 점수는 가장 높은 숫자에 900을 더한다. 예를 들어, 카드가 Y4, Y3, Y2, Y5, Y6 일 때 점수는 906(=6+900)점이다.
카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다. 예를 들어, 카드가 B3, R3, B7, Y3, G3 일 때 점수는 803(=3+800)점이다.
카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다. 예를 들어, 카드가 R5, Y5, G7, B5, Y7 일 때 점수는 757(=5x10+7+700)점이다.
5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다. 예를 들어, 카드가 Y3, Y4, Y8, Y6, Y7 일 때 점수는 608(=8+600)점이다.
카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다. 예를 들어 R7, R8, G9, Y6, B5 일 때 점수는 509(=9+500)점이다.
카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다. 예를 들어 R7, Y7, R2, G7, R5 일 때 점수는 407(=7+400)점이다.
카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더한다. 예를 들어, R5, Y5, Y4, G9, B4 일 때 점수는 354(=5X10+4+300)점이다.
카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다. 예를 들어, R5, Y2, B5, B3, G4 일 때 점수는 205(=5+200)점이다.
위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다. 예를 들어, R1, R2, B4, B8, Y5 일 때 점수는 108(=8+100)점이다.
입력으로 카드 5장이 주어질 때, 카드 게임의 점수를 구하는 프로그램을 작성하시오. 두 가지 이상의 규칙을 적용할 수 있는 경우에는 가장 높은 점수가 카드 게임의 점수이다.


{
 5장 같은색 && 연속적인 숫자 -> 가장높은수 + 900

 같은숫자 4장 -> 그 숫자 + 800

 3장 2장 이 숫자가 같을떄 -> 3장값 x 10 + 2장 값 + 700

 5장 같은색 -> 가장높은수 + 600 (O)

 5장 연속숫자  ->  가장 높은수 + 500 (o)

 3장의 숫자가 같을때 -> 같은수 + 400

 5장중 숫자 2장 2장 같을경우 -> 높은 숫자 x 10 + 숫자 + 300

 2장이 숫자 같을경우 -> 숫자 + 200

 아무것도 아닐경우 가장큰숫자 + 100
'''

Color = {"R" : 0 , "B" : 0, "Y" : 0, "G" : 0}
number = {"1" : 0 , "2" : 0 , "3" : 0 , "4" : 0, "5" : 0, "6": 0, "7": 0, "8": 0, "9" : 0}
Num = []

card = {}

first_num = 0
second_num = 0
point = 0


def check_color(color={}):
    if 5 in color.values():
        return True


def continuous_num(Num=[]):
    if max(Num) - min(Num) == 4:
        return True


def check_num(num={}):
    global first_num
    global second_num

    nums = num.copy()
    num = sorted(num.items(), key=lambda x: x[1], reverse=True)
    if 5 in nums.values():
        first_num = num[0][0]
        return 5
    elif 4 in nums.values():
        first_num = num[0][0]
        return 4
    elif 3 in nums.values():
        if num[1][1] == 2:
            first_num = num[0][0]
            second_num = num[1][0]
            return 3.2
        else:
            first_num = num[0][0]
            return 3
    elif 2 in nums.values():
        if num[1][1] == 2:
            if num[0][0] > num[1][0]:
                first_num = num[0][0]
                second_num = num[1][0]
            else:
                first_num = num[1][0]
                second_num = num[0][0]
            return 2.2
        else:
            first_num = num[0][0]
            return 2


for i in range(0, 5):
    a, b = input().split()
    Color[a] += 1
    number[b] += 1
    Num.append(int(b))


num_result = check_num(number)
Num.sort(reverse=True)


if check_color(Color) and continuous_num(Num):   #성공
    point = Num[0] + 900
elif num_result == 4:          # 성공
    point = int(first_num) + 800
elif num_result == 3.2:        # 성공
    point = int(first_num) * 10 + int(second_num) + 700
elif check_color(Color):             # 큰수 구하기 성공
    point = Num[0] + 600
elif continuous_num(Num):        # 큰수 구하기 성공
    point = Num[0] + 500
elif num_result == 3:
    point = int(first_num) + 400  #성공
elif num_result == 2.2:
    point = int(first_num) * 10 + int(second_num) + 300  # 성공
elif num_result == 2:
    point = int(first_num) + 200    #성공
else:
    point = Num[0] + 100   #성공

print(point)







