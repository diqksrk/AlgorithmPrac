//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Solution {
//	static Queue<Integer> queue=new LinkedList<>();
//	public static boolean prime_number_judgement(int number){
//		if (number==0 || number==1) return false;
//		else if (number==2) return true;
//		for (int i=2; i<Math.sqrt(number); i++){
//			if (number %i==0) return false;
//		}
//		return true;
//	}
//	
//	
//	public static void powerset(String data, int K, boolean[] visited){
//		if (K==data.length()){
//			StringBuilder str=new StringBuilder();
//			for (int i=0; i<data.length(); i++){
//				if (visited[i]) str.append(data.charAt(i));
//			}
//			if (!str.toString().equals("")){
//				int number=Integer.parseInt(str.toString());
//				if (prime_number_judgement(number)){
//					if (!queue.contains(number)){
//						queue.add(Integer.parseInt(str.toString()));
//					}
//					
//				}
//			}
//			return ;
//		}
//		visited[K]=true;
//		powerset(data, K+1, visited);
//		visited[K]=false;
//		powerset(data, K+1, visited);
//	}
//	
//	
//	public int solution(String numbers) {
//        int answer = 0;
//        boolean[] visited=new boolean[numbers.length()];
//       
//        for (int )
//        
//        powerset(numbers,0,visited);
//        
//        return answer;
//    }
//    
//    public static void main(String[] args) {
//    	String numbers="011";
//    	Solution sol=new Solution();
//    	sol.solution(numbers);
//
//    	return ;
//    }
//    
//    class Permutation {
//    	 
//        private int n; // nPr의 n
//        private int r; // nPr의 r
//        private int[] res;
//        
//        // 초기화
//        public Permutation(int n, int r){
//            this.n = n;
//            this.r = r;
//            res = new int[r];
//        }
//        
//        public void swap(int[] arr, int i, int j) {
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//     
//        public void perm(int[] arr, int depth) {
//            
//            // depth가 0부터 시작했을 경우 depth == r에서 리턴
//            if (depth == r) {
//                System.out.println(Arrays.toString(res));
//                return;
//            }
//            
//            for (int i = depth; i < n; i++) {
//                swap(arr, depth, i);     // 스왑
//                res[depth] = arr[depth]; // 선택된 원소 저장
//                perm(arr, depth +1);     // 재귀호출
//                swap(arr, depth, i);     // 복원
//            }
//        }
//    }
//}
//


public class Solution {
    public static void main(String[] ar){
        Solution ex = new Solution();
        int[] arr = { 1, 2,3};
        ex.doPermutation(arr, 0);
    }

    public void doPermutation(int[] arr, int startIdx){
        int length = arr.length;
        if(startIdx == length-1){
            for(int n: arr) System.out.print(n + " ");
            System.out.println();
            return;
        }

        for(int i=startIdx; i<length; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1);
            swap(arr, startIdx, i);
        }
    }

    public void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
