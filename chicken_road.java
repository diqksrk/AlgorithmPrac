//bfs
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static class Position {
		int x, y, count;
		public Position (int x, int y, int count){
			this.x=x;
			this.y=y;
			this.count=count;
		}
	}
	static int N,M, answer=0, count=1;
	static int[][] map;
	static Queue<Position> searching_list=new LinkedList<>();
	static boolean[][] visited;
	static int[][] dir={{0,-1}, {-1,0}, {0,1},{1,0}};
	static void Searching_road(){
		while (!searching_list.isEmpty()){
			Position earth=searching_list.poll();
			for (int z=0; z<4; z++){
				int next_x=earth.x+dir[z][0];
				int next_y=earth.y+dir[z][1];
				if (next_x<0 || next_y<0 || next_x>=N || next_y>=N) continue;
				if (visited[next_y][next_x]) continue;
				if (map[next_y][next_x]==1) answer+=earth.count;
				visited[next_y][next_x]=true;
				searching_list.add(new Position(next_x, next_y, earth.count+1));
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		M=Integer.parseInt(stn.nextToken());
		
		
		map=new int[N][N];
		visited=new boolean[N][N];
		for (int i=0; i<N; i++){
			stn=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				map[i][j]=Integer.parseInt(stn.nextToken());
				if (map[i][j]==2) {
					searching_list.add(new Position(j, i,1));
					visited[i][j]=true;
				}
			}
		}
		Searching_road();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(answer);
		
		
		return ;
	}
}

//dfs
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Solution {
	static class Position {
		int x, y, visit;
		public Position (int x, int y, int enable){
			this.x=x;
			this.y=y;
			this.visit=visit;
		}
	}
	static int N,M, count=1;
	static int answer=Integer.MAX_VALUE, len=Integer.MAX_VALUE;
	static int[][] map;
	static LinkedList<Position> chicken_list=new LinkedList<>();
	static LinkedList<Position> person_list=new LinkedList<>();
	static boolean[][] visited;
	static int[][] dir={{0,-1}, {-1,0}, {0,1},{1,0}};
	static void sol(int next_start, int M_count){
		if (M_count==M || chicken_list.size()==M_count){
			cal();
			return ;
		}
		
		for (int i=next_start; i<chicken_list.size(); i++){
			if (chicken_list.get(i).visit==0){
				chicken_list.get(i).visit=1;
				sol(i+1, M_count+1);
				chicken_list.get(i).visit=0;
			}
		}
	}
	
	static void cal(){
		int total=0;
		for (int i=0; i<person_list.size(); i++){
			Position po1=person_list.get(i);
			len=Integer.MAX_VALUE;
			for (int j=0; j<chicken_list.size(); j++){
				Position po2=chicken_list.get(j);
				if (po2.visit==1){
					int temp=Math.abs(po1.x-po2.x)+Math.abs(po1.y-po2.y);
					if (temp<len){
						len=temp;
					}
				}
			}
			total+=len;
		}
		if (total<answer) answer=total;
	}
	
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		M=Integer.parseInt(stn.nextToken());
		
		map=new int[N][N];
		visited=new boolean[N][N];
		for (int i=0; i<N; i++){
			stn=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				map[i][j]=Integer.parseInt(stn.nextToken());
				if (map[i][j]==1) {
					person_list.add(new Position(j, i,0));
					visited[i][j]=true;
				}
				if (map[i][j]==2) {
					chicken_list.add(new Position(j, i,0));
					visited[i][j]=true;
				}
			}
		}
		
		
		sol(0,0);
		System.out.println(answer);
		
		
		
		
		
		
		
		
		
		
		
		return ;
	}
}
