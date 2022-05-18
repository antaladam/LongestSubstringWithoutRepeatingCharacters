package Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1){return 1;}
        String current = "";
        int[] solutions = new int[100];
        int counter = 0;
        int solpos = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                if (current.indexOf(s.charAt(j)) == -1){
                    current += s.charAt(j);
                    counter++;
                    if (j == (s.length()-1)) {
                        solutions[solpos+1] = counter;
                    }
                }
                else {

                    solutions[solpos] = counter;
                    current = "";
                    counter = 0;
                    solpos++;
                    break;
                }
            }
        }
        IntStream asd = Arrays.stream(solutions).max().stream();
        return asd.sum();
    }
}