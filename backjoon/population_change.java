import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static class position {
		int x, y;
		public position (int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int N,L,R,ans;
	static int count, total;
	static boolean flag=true;
	static int[][] map;
	static Queue<position> union=new LinkedList<>();
	static Queue<position> truck=new LinkedList<>();
	static boolean[][] visited;
	static int[][] dir={{0,-1}, {-1,0},{0,1},{1,0}};
	
	static void judgement(){
		position standard_position=union.poll();
		for (int z=0; z<4; z++){
			int next_x=standard_position.x+dir[z][0];
			int next_y=standard_position.y+dir[z][1];
			int standard_vaule=map[standard_position.y][standard_position.x];
			if (next_x<0 || next_y<0 || next_x>=N || next_y>=N) continue;
			if (visited[next_y][next_x]) continue;
			if (L<=Math.abs(standard_vaule-map[next_y][next_x]) && Math.abs(standard_vaule-map[next_y][next_x])<=R){
				visited[next_y][next_x]=true;
				total+=map[next_y][next_x];
				count++;
				truck.add(new position(next_x, next_y));
				union.add(new position(next_x, next_y));
				flag=true;
			}
		}
	}
	
	static void make_union(){
		while (!union.isEmpty()){
			judgement();
		}
	}
	
	static void population_upgrade(){
		int value_of_middle=total/count;
		int length=truck.size();
		for (int i=0; i<length; i++){
			position temp=truck.poll();
			map[temp.y][temp.x]=value_of_middle;
		}
		total=0;
		count=0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		L=Integer.parseInt(stn.nextToken());
		R=Integer.parseInt(stn.nextToken());
		
		map=new int[N][N];
		visited=new boolean[N][N];
		for (int i=0; i<N; i++){
			stn=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				map[i][j]=Integer.parseInt(stn.nextToken());
			}
		}
		
		//while after .....
		
		//searching union
		
		while (flag){
			flag=false;
			ans++;
			visited=new boolean[N][N];
			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					if (!visited[i][j]){
						union.add(new position(j,i));
						truck.add(new position(j,i));
						total+=map[i][j];
						count++;
						visited[i][j]=true;
						make_union();
						population_upgrade();
					}
				}
			}
		}
		System.out.println(ans-1);
	}
	
	
	
}
