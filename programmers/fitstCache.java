import java.util.*;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> dd = new LinkedHashMap<>();

        for (String city : cities) {
            city = city.toUpperCase();
            if (dd.containsKey(city)) {
                dd.remove(city);
                dd.put(city, 1);
                answer += 1;
            } else {
                if (cacheSize > 0 && dd.size() >= cacheSize) {
                    dd.remove(dd.entrySet().stream().iterator().next().getKey());
                    dd.put(city, 1);
                } else if (cacheSize > 0 && dd.size() < cacheSize) {
                    dd.put(city, 1);
                }
                answer += 5;
            }
        }

        return answer;
    }
}
