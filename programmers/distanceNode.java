import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer> bfs = new ArrayList<>();
        ArrayList<Integer>[] path = new ArrayList[n+1];
        int[] dist = new int[n+1];
        int max = 0;

        dist[1] =  1;
        bfs.add(1);

        for (int i =0; i< edge.length; i++) {
            int num1 = edge[i][0];
            int num2 = edge[i][1];

            if (path[num1] == null) path[num1] = new ArrayList<>();
            if (path[num2] == null) path[num2] = new ArrayList<>();

            path[num1].add(num2);
            path[num2].add(num1);
        }


        while (!bfs.isEmpty()) {
            int index = bfs.remove(0);
            while (!path[index].isEmpty()) {
                int beforeLoad = path[index].remove(0);
                if (dist[beforeLoad] == 0) {
                    dist[beforeLoad] = dist[index] + 1;
                    max = dist[beforeLoad];
                    bfs.add(beforeLoad);
                }
            }
        }

        for (int i =0; i<dist.length; i++) {
            if (max == dist[i]) answer++;
        }

        return answer;
    }
}
