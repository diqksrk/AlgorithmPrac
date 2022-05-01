import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Node> node_list=new LinkedList<>();
        boolean[] visited=new boolean[n];
        for (int i=0; i<n; i++){
        	node_list.add(new Node(i+1));
        }
        
        for (int i=0; i<edge.length; i++){
        	node_list.get(edge[i][0]-1).adjacent.add(node_list.get(edge[i][1]-1));
        	node_list.get(edge[i][1]-1).adjacent.add(node_list.get(edge[i][0]-1));
        }
        
        Queue<Node> order_of_node=new ConcurrentLinkedQueue<>();
        node_list.get(0).count=0;
        order_of_node.add(node_list.get(0));
        visited[0]=true;
        while (!order_of_node.isEmpty()){
        	Node node=order_of_node.poll();
        	visited[node.vetex-1]=true;
        	for (Node adjacent : node.adjacent){
        		if (!visited[adjacent.vetex]){
        			adjacent.count=node.count+1;
        			order_of_node.add(node_list.get(node.adjacent.get(i).vetex-1));
        		}
        	}
        }
        int max=node_list.stream().mapToInt(node->node.count).max().getAsInt();
        
        return (int)node_list.stream().filter(node->node.count==max).count();
    }
    
    public static void main(String[] args) {
		int[][] edge={{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		Solution sol=new Solution();
		int n=6;
		Arrays.sort(edge, new Comparator<int[]>(){
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				final int time1=arg0[0];
				final int time2=arg1[0];
				return Integer.compare(time1, time2);
			}
		});
		
		sol.solution(n, edge);
		
		return ;
	}
    
    public class Node {
    	private int vetex;
    	private List<Node> adjacent=new ArrayList<>();
    	private int count=Integer.MAX_VALUE;
    	public Node(int vertex){
    		this.vetex=vertex;
    	}
    }
}
