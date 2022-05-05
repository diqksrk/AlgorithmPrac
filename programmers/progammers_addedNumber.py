def solution(numbers):
    addedNumber = set()
    numbersLength = len(numbers)

    for i in range(numbersLength):
        for j in range(i + 1, numbersLength):
            addedNumber.add(numbers[i] + numbers[j])

    return list(sorted(addedNumber))
