import math

def solution(progresses, speeds):
    answer = []
    days = []
    dayCount = 1

    for i in range(len(progresses)):
        days.append(math.ceil((100 - progresses[i]) / speeds[i]))

    standardDay = days.pop(0)
    for day in days:
        if (standardDay >= day):
            dayCount+=1
        else:
            answer.append(dayCount)
            standardDay = day
            dayCount=1

    if (dayCount != 0):
        answer.append(dayCount)

    return answer