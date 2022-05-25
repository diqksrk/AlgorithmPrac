import java.util.*;

class Solution {
	static void dfs(int n, int[][] computers, boolean[] visited, int current){
		visited[current]=true;
		for (int i=0; i<n; i++){
			boolean tf=visited[i];
			int tfi=computers[current][i];
			if (!visited[i] && computers[current][i]>0){
				dfs(n,computers, visited, i);
			}
		}
	}
	
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited=new boolean[n];
        
        for (int i=0; i<n; i++){
        	if (!visited[i]){
        		answer++;
            	dfs(n, computers, visited, i);
        	}
        }
        return answer;
    }
    
}
