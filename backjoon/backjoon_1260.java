import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.*;


class Solution {
	public static int nodeCnt;
	public static LinkedList<Integer>[] node_list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nodeCnt=Integer.parseInt(st.nextToken());
		int lineCnt=Integer.parseInt(st.nextToken());
		int start_node=Integer.parseInt(st.nextToken());
		
		node_list=new LinkedList[nodeCnt+1];
		
		for (int i=0; i<=nodeCnt; i++){
			node_list[i]=new LinkedList<Integer>();
		}
		
		for (int i=0; i<lineCnt; i++){
			st=new StringTokenizer(br.readLine());
			int node1=Integer.parseInt(st.nextToken());
			int node2=Integer.parseInt(st.nextToken());
			
			node_list[node1].add(node2);
			node_list[node2].add(node1);
			
			Collections.sort(node_list[node1]);
			Collections.sort(node_list[node2]);
		}
		
		StringBuilder dfs_result=new StringBuilder();
		StringBuilder bfs_result=new StringBuilder();
		
		boolean[] dfsVisited=new boolean[nodeCnt+1];
		boolean[] bfsVisited=new boolean[nodeCnt+1];
		
		dfs(start_node, dfsVisited, dfs_result);
		bfs(start_node, bfsVisited, bfs_result);
		
		System.out.println(dfs_result+"\n"+bfs_result);
		
	}
	
	
	public static void dfs(int node, boolean[] visited, StringBuilder sb){
		if (visited[node]) return ;
		
		visited[node]=true;
		
		sb.append(node+" ");
		for (int next_node:node_list[node]){
			dfs(next_node, visited, sb);
		}
	}
	
	public static void bfs(int node, boolean[] visited, StringBuilder sb){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		
		while (!queue.isEmpty()){
			node=queue.poll();
			
			if (visited[node]) continue;
			visited[node]=true;
			sb.append(node+" ");
			
			for (int next_node:node_list[node]){
				queue.add(next_node);
			}
		}
		
		
	}
	
	
}
