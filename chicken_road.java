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
