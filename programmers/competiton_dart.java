import java.util.*;

class Solution {

    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;

        int[] answerArray = new int[3];
        char[] dd = dartResult.toCharArray();

        String number = new String();
        for (int i = 0; i < dd.length; i++) {
            if (dd[i] == 'S') {
                answerArray[idx] = (int) Math.pow(Integer.parseInt(number), 1);
                idx++;
                number = "";
            } else if (dd[i] == 'D') {
                answerArray[idx] = (int) Math.pow(Integer.parseInt(number), 2);
                idx++;
                number = "";
            } else if (dd[i] == 'T') {
                answerArray[idx] = (int) Math.pow(Integer.parseInt(number), 3);
                idx++;
                number = "";
            } else if (dd[i] == '*') {
                answerArray[idx -1] = answerArray[idx - 1]*2;

                if (idx > 1) {
                    answerArray[idx - 2] = answerArray[idx - 2] * 2;
                }
            } else if (dd[i] == '#') {
                answerArray[idx - 1] = answerArray[idx - 1]*(-1);
            } else {
                number += String.valueOf(dd[i]);
            }
        }

        return Arrays.stream(answerArray).sum();
    }
}
