import java.util.*;

class Solution {
	class imigration_officer {
		int process_speed;
	}
	
	public static int get_currentIncomePeople(int current_income_people, int[] times, int times_length, long current_time){
		for (int i=0; i<times_length; i++){
			current_income_people+=current_time/times[i];
		}
		return current_income_people;
	}
	
	
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        
        //times_length=2(7,10)
        int first_officer_time=times[0]*6;
        int times_length=times.length;
        for (int i=0; i<times.length; i++){
        	if (first_officer_time<times[i]){
        		times_length=i;
        	}
        }
        
      //set the standard for binary search
        long standard=n*times[times_length-1];
        
        long start=0;
        long end=standard;
        boolean flag=false;
        //start=61? end=60
        while (start<=end){
        	if (flag==true) break;
        	//30
        	long mid=(start+end)/2;
//        	long mid=29;
        	int current_income_people=0;
        	
        	//14
        	current_income_people=get_currentIncomePeople(current_income_people, times, times_length, mid);
        	//14<6
        	if (current_income_people<n) start=mid+1;
        	//6<14
        	else if (n<current_income_people) {
        		current_income_people=0;
        		long fake_mid=mid-1;
        		current_income_people=get_currentIncomePeople(current_income_people, times, times_length, fake_mid);
        		if (current_income_people<n){
        			answer=mid;
        			break;
        		}
        		end=mid-1; 
        	}
        	
        	//6=6(cur_incom_people)
        	else {
        		while (true){
        			current_income_people=0;
            		mid-=1;
            		current_income_people=get_currentIncomePeople(current_income_people, times, times_length, mid);
            		if (current_income_people<n){
            			answer=mid+1;
            			flag=true;
                		break;
            		}
        		}
        	}
        	
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int n=6;
    	int[] times={4,10};
    	Solution sol=new Solution();
    	System.out.println(sol.solution(n, times));
	}
}
