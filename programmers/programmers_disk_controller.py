import heapq as hq
import math

def solution(jobs):
    answer, cnt, time, lenjob = 0, 0, 0, len(jobs)
    heap = []
    jobs.sort()

    while lenjob > cnt :
        while len(jobs) > 0:
                if jobs[0][0] <= time :
                    hq.heappush(heap, jobs.pop(0)[::-1])
                else:
                    break

        if (len(heap) > 0):
            workInfo = hq.heappop(heap)
            time += workInfo[0]
            stdTime = time - workInfo[1]
            cnt += 1
            answer += stdTime
        else:
            time += 1

    return math.floor(answer / cnt)
