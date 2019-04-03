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


//second solving method
import java.util.*;

class Solution {
	int dfs(int[] numbers, int depth, int sum, int target){
		int answer=0;
		if (depth==numbers.length){
			if (sum==target){
				return 1;
			}else {
				return 0;
			}
		}
		return dfs(numbers,depth+1,sum+numbers[depth],target)+dfs(numbers,depth+1,sum-numbers[depth],target);
	}
	
    public int solution(int[] numbers, int target) {
        int answer=0;
        answer=dfs(numbers,0,0,target);
        return answer; 
    }
    
    public static void main(String[] args) {
    	int[] numbers={1,1,1,1,1};
    	int target=3;
    	
    	Solution sol=new Solution();
    	sol.solution(numbers, target);
	}
}
