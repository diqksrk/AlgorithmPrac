import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	static class death_tree_info {
		int x,y,z,age;
		public death_tree_info(int x, int y, int z,int age){
			this.x=x;
			this.y=y;
			this.z=z;
			this.age=age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stn.nextToken());
		int M=Integer.parseInt(stn.nextToken());
		int K=Integer.parseInt(stn.nextToken());
		
		//make nutrion info and current nutrion info
		int[][] add_nutrion_info=new int[N][N];
		int[][] cur_nutrion_info=new int[N][N];
		for (int i=0; i<N; i++){
			stn=new StringTokenizer(br.readLine());
			int length=stn.countTokens();
			for (int j=0; j<length; j++){
				add_nutrion_info[i][j]=Integer.parseInt(stn.nextToken());
				cur_nutrion_info[i][j]=5;
			}
		}
		
		Queue<death_tree_info> dti_queue=new LinkedList<>();
		
		//make tree info
		ArrayList<Integer>[][] tree_info=new ArrayList[200][200];
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				tree_info[i][j]=new ArrayList<>();
			}
		}
		for (int i=0; i<M; i++){
			stn=new StringTokenizer(br.readLine());
			int y=Integer.parseInt(stn.nextToken());
			int x=Integer.parseInt(stn.nextToken());
			int tree_age=Integer.parseInt(stn.nextToken());
			tree_info[y-1][x-1].add(tree_age);
		}
		
		//after year add
		for (int u=0; u<K; u++){
			int result=0;
			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					result+=tree_info[i][j].size();
				}
			}
			System.out.println("u : "+u +" ,  result : " +result);
		
			//spring.
			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					Collections.sort(tree_info[i][j]);
					int size=tree_info[i][j].size();
					if (size>0){
						int death_count=0;
						for (int k=0; k<size; k++){
							if (tree_info[i][j].get(k)>cur_nutrion_info[i][j]) {
								for (int y=k; y<size; y++){
									dti_queue.add(new death_tree_info(j, i, y, tree_info[i][j].get(y)));
								}
								for (int y=k; y<size; y++){
									tree_info[i][j].remove(tree_info[i][j].size()-1);
								}
								break;
							}else {
								cur_nutrion_info[i][j]-=tree_info[i][j].get(k);
								int tree_age=tree_info[i][j].get(k);tree_age++;
								tree_info[i][j].set(k, tree_age);
							}
						}
					}
				}
			}
			
			//여름-양분 (아직 테스트 노)
			int death_tree_size=dti_queue.size();
			for (int i=0; i<death_tree_size; i++){
				death_tree_info dti=dti_queue.poll();
				cur_nutrion_info[dti.y][dti.x]+=dti.age/2;
			}
			
			//fall-번식
			int[][] dir={{-1,-1}, {0,-1}, {1,-1}, {-1,0}, {1,0},{-1,+1}, {0,+1}, {+1,+1}};
//			int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					int size=tree_info[i][j].size();
					if (size>0){
						for (int k=0; k<size; k++){
							if (tree_info[i][j].get(k)%5==0){
								for (int z=0; z<8; z++){
									int dirx=j+dir[z][0];
									int diry=i+dir[z][1];
									if (dirx<0 || diry<0 || dirx>=N || diry >=N) continue;
									tree_info[diry][dirx].add(1);
								}
							}
						}
					}
				}
			}
			
			//winter
			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					cur_nutrion_info[i][j]+=add_nutrion_info[i][j];
				}
			}
		}
		
		int result=0;
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				result+=tree_info[i][j].size();
			}
		}
		
		System.out.println(result);
		
		return ;
	}
}
