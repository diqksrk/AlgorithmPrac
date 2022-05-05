import heapq as pq

def solution(scoville, K):
    numberOfAttempts = 0
    pq.heapify(scoville)

    while True:
        lowestFoodScovile = pq.heappop(scoville)

        if lowestFoodScovile >= K:
            break

        if (len(scoville) == 0):
            return -1

        numberOfAttempts += 1
        pq.heappush(scoville, lowestFoodScovile + pq.heappop(scoville) * 2)

    return numberOfAttempts
