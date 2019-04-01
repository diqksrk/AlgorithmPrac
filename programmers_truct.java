import java.util.*;

class tructWeight_time{
	int truct_weight;
	int flow_time;
	public tructWeight_time(int truct_weight){
		this.truct_weight=truct_weight;
		this.flow_time=0;
	}
}

class Solution {
	void test(int flow_time,int current_weight, int bridge_length, int weight, int[] truck_weights, int index, List<Integer> truct_passed,List<tructWeight_time> truct_passing){
		System.out.print("flow_time : "+flow_time+" ,current_weight : "+current_weight+", bridge_length : "+ bridge_length + ", weight : "+ weight+", truct_passed : ");
		for (int truct_weight : truct_passed){
			System.out.print(truct_weight+", ");
		}System.out.print("truct_passing : ");
		for (int i=0; i<truct_passing.size(); i++){
			System.out.print(truct_passing.get(i).truct_weight+", ");
		}System.out.print("truct_weigth : ");
		for (int i=index; i<truck_weights.length; i++){
			System.out.print(truck_weights[i]+", ");
		}
		System.out.println();
	}
	
	boolean person_passing_judgment(int current_weight,int weight ,int[] truck_weights,int index){
		if (truck_weights.length>index){
			if (current_weight+truck_weights[index]<=weight){
				return true;
			}else {
				return false;
			}
		}
		return false;
		
	}
	
	boolean person_passed_judgment(List<tructWeight_time> truct_passing, int bridge_length){
		if (truct_passing.size()>0){
			if (truct_passing.get(0).flow_time==bridge_length){
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	void person_put_to_list(List<tructWeight_time> truct_passing, int[] truck_weights,int index){
		truct_passing.add(new tructWeight_time(truck_weights[index]));
	}
	
	void person_put_to_result_list(List<Integer> truct_passed, List<tructWeight_time> truct_passing){
		truct_passed.add(truct_passing.remove(0).truct_weight);
	}

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, index=0,current_weight=0, flow_time=0;
        List<Integer> truct_passed=new LinkedList();
        List<tructWeight_time> truct_passing=new LinkedList();
//        test(flow_time,current_weight, bridge_length, weight, truck_weights, index,truct_passed, truct_passing);
        while (truct_passed.size()<truck_weights.length){
//        for (int i=0; i<100; i++){
        	if (person_passed_judgment(truct_passing, bridge_length)){
        		current_weight-=truct_passing.get(0).truct_weight;
        		person_put_to_result_list(truct_passed, truct_passing);
        	}
        	if (person_passing_judgment(current_weight, weight, truck_weights,index)){
            	person_put_to_list(truct_passing, truck_weights,index);
            	current_weight+=truck_weights[index];
            	index++;
            }
        	
        	for (int j=0; j<truct_passing.size(); j++){
        		truct_passing.get(j).flow_time++;
        	}
        	flow_time++;
//        	test(flow_time,current_weight, bridge_length, weight, truck_weights, index,truct_passed, truct_passing);
        }
        answer=flow_time;
        return answer;
    }
    public static void main(String[] args) {
    	Solution sol=new Solution();
    	int bridge_length=100;
		int weight=100;
		int[] truck_weights={10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(sol.solution(bridge_length, weight, truck_weights));
	}
}
