import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

//class checking_officer implements Comparable<String[]>{
//
////	@Override
//	public int compareTo(String[] o) {
//		// TODO Auto-generated method stub
//		if (o[0].equals("ICN")){
//			if ())
//		}else if ()
//		return 0;
//	}
//	
//}

class Solution {
    public String[] solution(String[][] tickets) {
    	String[] answer=new String[tickets.length+1];
        List<String> travel_order=new LinkedList<>();
        Queue<String[]> queue_tickets=new ConcurrentLinkedQueue<>();
        boolean[] visited=new boolean[tickets.length];
        
      //checking for several posible way (priority : a>b>....)
    	Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(final String[] o1, final String[] o2) {
				if (o1[0].equals(o2[0])){
					if (o1[1].compareTo(o2[1])>0){
						return 1;
					}else {
						return -1;
					}
				}else  if (o1[0].compareTo(o2[0])>0){
					return 1;
				}else {
					return -1;
				}
			}
    		
		});
        
    	//check for first departure
        int index=0;
        for (int i=0; i<tickets.length; i++){
        	if (tickets[i][0].equals("ICN")){
        		visited[i]=true;
        		queue_tickets.add(tickets[i]);
        		answer[0]=tickets[i][0];
        		break;
        	}
        }
        
        //icn checking and put the travel_order
        String[] ticket=queue_tickets.poll();
        travel_order.add(ticket[0]);
        
        //next jfk and find position of jfk
        String current_ticket=ticket[1];
        int count=1;
        dfs(current_ticket, tickets, visited, travel_order, answer,count);
        
        
        //travel_order linked_list to String[][]
//        answer=travel_order.toArray(new String[travel_order.size()]);
//        String[] answer=new String[travel_order.size()];
//        for (int i=0; i<travel_order.size(); i++){
//        	answer[i]=travel_order.get(i);
//        }
//        String[] answer={"1","2","3"};
//        travel_order.toArray(new String[travel_order.size()]);
        
//        String[] answer=new String[travel_order.size()];
        
        return answer;
    }
    
    public static void dfs(String current_ticket, String[][] tickets, boolean[] visited, List<String> travel_order,String[] answer, int count){
    	for (int i=0; i<tickets.length; i++){
    		//whole road roamed then return
    		if (travel_order.size()-1==tickets.length){
    			return ;
    		}
    		
    		//checking for next departure, checking for the way i go
        	if (current_ticket!=tickets[i][0] || visited[i]) continue;
        	visited[i]=true;
        	travel_order.add(current_ticket);
        	answer[count]=current_ticket;
        	
        	//whole road roamed then return
        	if (travel_order.size()==tickets.length) {
        		travel_order.add(tickets[i][1]);
        		answer[count+1]=tickets[i][1];
        		return ;
        	}
        	
        	//loop with starting point and departure
        	dfs(tickets[i][1], tickets, visited, travel_order,answer, count+1);
        }
    }
    
    
    public static void main(String[] args) {
    	Solution sol=new Solution();
    	
    	
    	String[][] tickets={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    	Arrays.stream(sol.solution(tickets)).forEach(v->System.out.print(v+" "));
	}
}
