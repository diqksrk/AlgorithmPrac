import java.util.*;

class Person{
	int location;
	public Person(int location) {
		this.location=location;
	}
	
	void test_of_List(List<Integer> queueofpriorities){
		int length=queueofpriorities.size();
		System.out.print("location : "+location+" [ ");
		for (Iterator<Integer> iter=queueofpriorities.iterator(); iter.hasNext();){
			System.out.print(iter.next()+", ");
		}
		System.out.println();
	}
}


class Solution{
	private List<Integer> queueofpriorities=new LinkedList();
	
	class Person_PutToQueue extends Person{
		public Person_PutToQueue(int location) {
			super(location);
		}
		
		public List<Integer> PutToQueue(List<Integer> queueofpriorities, int[] priorities){
			for (int i=0; i<priorities.length; i++){
	        	queueofpriorities.add(priorities[i]);
	        }
			return queueofpriorities;
		}
	}
	
	class Person_checkForQueue extends Person{
		
		public Person_checkForQueue(int location) {
			super(location);
		}
		
		
		int location_adjustment(int location, int sizeofprioriyqueue){
			if (location-1>=0){
				location-=1;
			}else {
				location=sizeofprioriyqueue-1;
			}
			return location;
		}
		
		int check_for_queue(List<Integer> queueofpriorities){
			int ordernumber_of_print=1;
			while (!queueofpriorities.isEmpty()){
				final Integer document=queueofpriorities.get(0);
				if (queueofpriorities.stream().anyMatch(v->document<v)){
					queueofpriorities.add(queueofpriorities.remove(0));
				}else {
					if (location==0){
						return ordernumber_of_print;
					}
					queueofpriorities.remove(0);
					ordernumber_of_print++;
				}
				
				location=location_adjustment(location, queueofpriorities.size());
			}
			throw new RuntimeException();
		}
	}
	
	class system_sceen{
		int showing_the_result(int ordernumber_of_print){
			return ordernumber_of_print;
		}
	}
	
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Person_PutToQueue employee_kim=new Person_PutToQueue(5);
        Person_checkForQueue employee_kang=new Person_checkForQueue(5);
        system_sceen sc=new system_sceen();
        
        employee_kim.PutToQueue(queueofpriorities, priorities);
        //test
        employee_kim.test_of_List(queueofpriorities);
        
        answer=sc.showing_the_result(employee_kang.check_for_queue(queueofpriorities));
        
        return answer;
    }
    
    
	public static void main(String[] args) {
		Solution sol=new Solution();
		Integer location=new Integer(5);
		int total=0;
		
		int[] priorities={1,1,1,3,1,1};
		System.out.println("answer : "+sol.solution(priorities, location));
	}
}
