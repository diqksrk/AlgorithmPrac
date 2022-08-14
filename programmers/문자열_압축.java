class Solution {

    public int solution(String s) {
        int answer = 0;
        int min = s.length();

        for (int k = 1; k <= s.length()/2; k++) {

            String before = "";
            int count = 1;
            int sum = 0;
            for (int i = 0; i<s.length();) {
                int start = i;
                i = (i+k > s.length()) ? s.length() : i + k;
                String cur = s.substring(start, i);

                if (cur.equals(before)) {
                    count++;
                } else {
                    if (count != 1) {
                        sum += (int) Math.log10(count) + 1;
                    }
                    count = 1;
                    sum += before.length();
                    before = cur;
                }
            }

            sum += before.length();
            if (count != 1) {
                sum += (int) Math.log10(count) + 1;
            }

            min = Math.min(sum, min);
        }

        answer = min;
        return answer;
    }
}
