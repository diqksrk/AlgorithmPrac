//first solution
import java.util.*;

class Solution {
	private int answer=0;
	void depth_first_search(int[] numbers, int target, int[] flag, int depth){
		if (depth==numbers.length){
			int sum=0;
			for (int i=0; i<numbers.length; i++){
				if (flag[i]==1){
					sum+=numbers[i];
				}else {
					sum-=numbers[i];
				}
			}
			if (sum==target) answer++;
			return ;
		}
		
		flag[depth]=1;
		depth_first_search(numbers, target, flag, depth+1);
		
		flag[depth]=0;
		depth_first_search(numbers, target, flag, depth+1);
	}
	
    public int solution(int[] numbers, int target) {
        int depth=0;
        int[] flag=new int[numbers.length];
        depth_first_search(numbers, target, flag, depth);
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] numbers={1,1,1,1,1};
    	int target=3;
    	
    	Solution sol=new Solution();
    	sol.solution(numbers, target);
	}
}
