import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            StringTokenizer stringTokenizer = new StringTokenizer(op);
            String direction = stringTokenizer.nextToken();
            int value = Integer.parseInt(stringTokenizer.nextToken());

            if (pq.size() < 1 && direction.equals("D")) {
                continue;
            }

            if (direction.equals("I")) {
                pq.offer(value);
                maxpq.offer(value);
                continue;
            }

            if (value < 0) {
                int min = pq.poll();
                maxpq.remove(min);
                continue;
            }
            //최대 힙에서 poll후 최소힙에서 해당 원소 삭제
            int max = maxpq.poll();
            pq.remove(max);
        }

        if(pq.size() > 0 ) {
            answer[0] = maxpq.poll();
            answer[1] = pq.poll();
        }

        return answer;
    }
}
