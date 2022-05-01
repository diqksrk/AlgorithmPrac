import java.util.*;

class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//        return answer;
//    }
	
	static void powerSet(char[] data, int[] flag, int n) {
		if (n==data.length){
			printData(data, flag);
			return ;
		}
		
		flag[n]=1;
		powerSet(data, flag, n+1);
		
		flag[n]=0;
		powerSet(data, flag, n+1);
	}
	
	static void printData(char[] data, int[] flag) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 1) {
                System.out.print(data[i] + "\t");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
//    	int[] numbers={1,1,1,1,1};
//    	int target=3;
    	
    	char[] data = {'a', 'b', 'c'};
        int[] flag = new int[data.length];

    	
    	Solution sol=new Solution();
    	powerSet(data, flag, 0);
//    	sol.solution(numbers, target);
	}
}
