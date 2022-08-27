def solution(lottos, win_nums):
    answer = 0
    rank = [6, 6, 5, 4, 3, 2, 1]
    
    print(lottos)
    print(win_nums)
    
    cnt_0 = lottos.count(0)
    for i in win_nums:
        if i in lottos:
            answer += 1
            
    return rank[cnt_0 + answer], rank[answer]
