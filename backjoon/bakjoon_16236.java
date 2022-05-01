import java.util.*;
import java.awt.Shape;
import java.io.*;
 

class Shark {
	int x, y, move;
	public Shark(int x, int y,int move){
		this.x=x;
		this.y=y;
		this.move=move;
	}
}

class ySort implements Comparator<Shark> {
    public int compare(Shark i1, Shark i2) {
        if (i1.y < i2.y) {
            return -1;
        } else if (i1.y == i2.y) {
            if (i1.x < i2.x) {
                return -1;
            } else if (i1.x == i2.x) {
                return 0;
            }
            return 1;
        } else {
            return 1;
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
    	int shark_size=2, cnt=0;
    	int[] dx = { -1, 0, 1, 0 };
    	int[] dy = { 0, -1, 0, 1 };
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		Shark shark=new Shark(0,0,0);
		int size=Integer.parseInt(st.nextToken());
		int[][] map=new int[size][size];
		for (int y=0; y<size; y++){
			st=new StringTokenizer(br.readLine());
			for (int x=0; x<size; x++){
				map[y][x]=Integer.parseInt(st.nextToken());
				if (map[y][x]==9){
					shark.x=x;
					shark.y=y;
					map[y][x]=0;
				}
			}
		}
		int eat=0;
		int time=0;
		while (true){
			Queue<Shark> q = new LinkedList<>();
			ArrayList<Shark> fishes=new ArrayList<>();
			q.add(shark);
			boolean[][] visited=new boolean[size][size];
			visited[shark.y][shark.x]=true;
			int found=-1;
			while (!q.isEmpty()){
				Shark sShk=q.poll();
				int x=sShk.x;
				int y=sShk.y;
				int move=sShk.move;
				if (found==move) break;
				
				for (int k=0; k<4; k++){
					int next_x=x+dx[k];
					int next_y=y+dy[k];
					 if (0 <= next_x && next_x < size && 0 <= next_y && next_y < size) {
		                    if (visited[next_y][next_x]) {
		                        continue;
		                    }
		                    visited[next_y][next_x]=true;
		                    if (shark_size>=map[next_y][next_x]){
		                    	 if (map[next_y][next_x] > 0 && shark_size > map[next_y][next_x]) {
		                             // 물고기를 먹을 수 있는 곳을 찾음. 현재 이동거리까지만 BFS 탐색하고 중단.
		                             found = move + 1;
		                             fishes.add(new Shark(next_x, next_y, move + 1));
		                         }
		                    	q.add(new Shark(next_x, next_y, move+1));
							 }
							 
					 }
				}
			}
			
			if (found==-1){
				break;
			}else {
				if (fishes.size()>1){
					Collections.sort(fishes, new ySort());
				}
			}
			
			Shark fish=fishes.get(0);
			
			if (found != -1) {
	            time += found;
	            map[shark.y][shark.x] = 0;
	            shark.x = fish.x;
	            shark.y = fish.y;
	            map[shark.y][shark.x] = 9;
	            if (shark_size == ++cnt) {
	                shark_size++;
	                cnt = 0;
	            }
	        }
		}
		System.out.println(time);
	}
}
