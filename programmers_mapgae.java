import java.util.*;
import java.util.stream.Collectors;

import examprac.priorityqueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        //insert to priority_queue with socvill_value
        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        while (true){
        	int scoville_figure1=pq.poll();
        	if (pq.size()==0 && scoville_figure1<K){
        		answer=-1;
        		break;
        	}
        
        	if (scoville_figure1<K){
        		int scoville_figure2=pq.poll();
        		pq.add(scoville_figure1+scoville_figure2*2);
        		answer++;
        	}else if (scoville_figure1>=K){
        		break;
        	}
        }
        if (scoville.length==1) answer=-1;
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] scoville={1,2,3,9,10,12}; 
    	int K=7;
    	Solution sol=new Solution();
    	System.out.println(sol.solution(scoville, K));
	}
}
