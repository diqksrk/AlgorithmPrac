import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int n, x,y, d,g;
	static List<Integer> curves;
	static int map[][]=new int[101][101];
	static int[] Dx={1,0,-1,0};
	static int[] Dy={0,-1,0,1};
	static int solve() {
		int ret=0;
		for (int i=0; i<100; i++){
			for (int j=0; j<100; j++){
				if (map[i][j]==1 && map[i][j+1]==1 && map[i+1][j]==1 && map[i+1][j+1]==1){
					++ret;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(stn.nextToken());
		
		for (int i=0; i<n; i++){
			curves=new ArrayList<>();
			stn=new StringTokenizer(br.readLine());
			x=Integer.parseInt(stn.nextToken());
			y=Integer.parseInt(stn.nextToken());
			d=Integer.parseInt(stn.nextToken());
			g=Integer.parseInt(stn.nextToken());
			
			curves.add(d);
			
			for (int j=0; j<g; ++j){
				for (int k=curves.size()-1; k>=0; --k){
					curves.add((curves.get(k)+1)%4);
				}
			}
			
			map[y][x]=1;
			for (int dir : curves){
				x+=Dx[dir];
				y+=Dy[dir];
				map[y][x]=1;
			}
		}
		System.out.println(solve());		
	}
}
