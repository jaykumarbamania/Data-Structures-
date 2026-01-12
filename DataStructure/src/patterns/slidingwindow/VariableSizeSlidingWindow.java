package patterns.slidingwindow;


import java.util.HashSet;
import java.util.Set;

class VariableSizeSlidingWindow {

    public static void main(String[] args) {
        String str = "abcdefghbcdeeaabcbbc";
        System.out.println(bruteForce(str));
    }

    private static int bruteForce(String str) {
        int maxStr = Integer.MIN_VALUE;
        Set<Character> word = new HashSet<>();

        for(int i = 0; i<= str.length(); i++){
            for(int j=0; j< str.length(); j++){
                if(!word.contains(str.charAt(j))) {
                    word.add(str.charAt(j));
                    maxStr = Math.max(maxStr, word.size());
                } else {
                    break;
                }
            }
        }
        return maxStr;
    }

    private static int window(String str) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        Set<Character> window = new HashSet<>();

        for(int right = 0; right < str.length(); right++){
            while(window.contains(str.charAt(right))) {
                window.remove(str.charAt(left));
                left++;
            }

            window.add(str.charAt(right));

            maxLength = Math.max(maxLength, window.size());
        }
        return maxLength;
    }
}