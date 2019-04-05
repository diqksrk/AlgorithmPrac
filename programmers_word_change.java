import java.util.*;

class Solution {
	static int answer=0;
	static void dfs(String begin, String target, String[] words, int numberofvisit, String history){
		for (int i=0; i<words.length; i++){
			if (begin==target){
				answer=numberofvisit++;
				return ;
			}
			if (history.contains(words[i])) continue;
			history=history+" "+words[i]; int count=0;
			for (int j=0; j<words[i].length(); j++){
				if (words[i].charAt(j)!=begin.charAt(j)){
					count++;
					continue;
				}
				if (count>=2) break;
			}
			if (count<2){
				dfs(words[i], target, words,numberofvisit+1,history);
			}
		}
	}
	
	
    public int solution(String begin, String target, String[] words) {
        String history="";
        int numberofvisit=0;
    	dfs(begin, target, words, numberofvisit,history);
        return answer>0 ? answer : 0;
    }
    
    public static void main(String[] args) {
    	int numberofvisit=0;
    	String history;
    	String begin="hit";
    	String target="cog";
    	String[] words={"hot", "dot", "dag", "lat", "lag", "cog"};
    	Solution sol=new Solution();
    	System.out.println(sol.solution(begin, target, words));
	}
}
