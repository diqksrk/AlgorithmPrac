import java.util.*;
//dfs
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


//bfs
import java.util.*;
class Solution {
public static int solution(String begin, String target, String[] words) {

        Queue<String> queue = new LinkedList<String>();
        queue.offer(begin);

        boolean has_target = false;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                has_target = true;
            }
        }
        if(!has_target) return 0;


        int answer = 0;

        while(true) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(str.equals(target)) return answer;

                for(int j=0; j<words.length; j++){
                    if(diff(str, words[j])==1){
                        queue.offer(words[j]);
                    }
                }
            }
            answer += 1;

            if(answer > words.length) return 0;
        }

    }

    public static int diff(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
    	String begin="hit";
    	String target="cog";
    	String[] words={"hot", "dot", "dog", "lot", "cog"};
		System.out.println(solution(begin, target, words));
	}
    
    
}
