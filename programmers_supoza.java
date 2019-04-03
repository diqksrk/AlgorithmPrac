
import java.util.*;
import java.util.PriorityQueue;

import javax.management.ObjectName;

class GradeCard implements Comparable<GradeCard>{
	int idx;
	int right_number;
	
	public GradeCard(int idx, int right_number) {
		this.idx=idx;
		this.right_number=right_number;
	}
	
	@Override
	public int compareTo(GradeCard o) {
		if (this.right_number<o.right_number)
			return 1;
		else if (this.right_number==o.right_number){
			if (this.idx<o.idx)
				return -1;
			else 
				return 1;
		}else 
			return -1;
	}
}


class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern={{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int count;
        PriorityQueue<GradeCard> pq=new PriorityQueue<>();
        
        //구별하는 object
        for (int i=0; i<pattern.length; i++){
        	count=0;
        	for (int j=0; j<answers.length; j++){
        		if (pattern[i][j%pattern[i].length]==answers[j]) count++;
        	}
        	//넣는 object
        	pq.add(new GradeCard(i, count));
        }
        
        int length=pq.size();
        LinkedList<Integer> temp=new LinkedList<Integer>();
        
        GradeCard gc=pq.poll();
        temp.add(gc.idx);
        int max=gc.right_number;
        for (int i=0; i<length-1; i++){
        	GradeCard tempgc=pq.poll();
        	int temp_int=tempgc.right_number;
        	if (max==temp_int){
        		temp.add(tempgc.idx);
        	}
        }
        return temp.stream().mapToInt(i->i.intValue()).toArray();
    }
    
    public static void main(String[] args) {
    	int[] answer={1,2,3};
		Solution sol=new Solution();
		int[] answers={1,3,2,4,2};
		sol.solution(answers);
	}
}
