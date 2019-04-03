import java.util.*;

class Solution {
	public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
	
    public String[] solution(String[] card, String[] word) {
        String[] answer = {};
        int lengh1=card.length;
        StringBuilder overlap_check=new StringBuilder();
        for (int i=0; i<card.length; i++){
        	card[i]=sortString(card[i]);
        }
        for (int i=0; i<word.length; i++){
        	word[i]=sortString(word[i]);
        }
        
        for (int i=0; i<card.length; i++){
        	for (int j=0; j<word.length; j++){
        		for (int k=0; k<word[j].length(); k++){
        			for (int u=0; u<card[j].length(); u++){
        				if (word[u]==card[i]){
        					
        				}
        			}
        		}
        	}
        }
        
//        for (int i=0; i<lengh1; i++){
//        	int length2=card[i].length();
//        	for (int j=0; j<word.length; j++){
//        		for (int k=0; k<length2; k++){
//        			
//        				
//        			
//            	}
//        	}
//        }
        return answer;
    }
    
    public static void main(String[] args) {
		String[] card=new String[]{"ABCDEFG", "NOPQRSTU", "HIJKLKMM"};
		String[] word=new String[]{"GPQM", "GPMZ", "EFU", "MMNA"};
		Solution sol=new Solution();
		sol.solution(card, word);
	}
}
