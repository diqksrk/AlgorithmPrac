def solution(prices):
    answer = []
    for i in range(len(prices)):
        notDescendingTime = 0
        standardStockPrice = prices[i]
        for j in range(i + 1 , len(prices)):
            curStockPrice = prices[j]
            notDescendingTime += 1

            if (standardStockPrice > curStockPrice):
                break

        answer.append(notDescendingTime)

    return answer
