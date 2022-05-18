package Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1){return 1;}
        String current = "";
        int[] solutions = new int[100];
        int counter = 0;
        int solpos = 0;
        for (int i = 0; i < s.length(); i++){
            if (current.indexOf(s.charAt(i)) == -1){
                current += s.charAt(i);
                counter++;
                if (i == (s.length()-1)) {
                    solutions[solpos+1] = counter;
                }
            }
            else {
                solutions[solpos] = counter;
                current = String.valueOf(s.charAt(i));
                counter = 1;
                solpos++;
            }

        }
        for (int j = (s.length()-1); j > 0; j--){
            if (current.indexOf(s.charAt(j)) == -1){
                current += s.charAt(j);
                counter++;
                if (j == 1) {
                    solutions[solpos+1] = counter;
                }
            }
            else {
                solutions[solpos] = counter;
                current = String.valueOf(s.charAt(j));
                counter = 1;
                solpos++;
            }

        }
        IntStream asd = Arrays.stream(solutions).max().stream();
        return asd.sum();
    }
}
