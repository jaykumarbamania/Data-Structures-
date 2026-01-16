package patterns.slidingwindow;

public class MinSizeSubArrSumGreaterThanTarget {
    public static void main(String[] args) {
        int[] intArr = new int[]{2,1,5,1,3,2};
        int k = 5;
        System.out.println(optimise(intArr, k));
    }

    private static int bruteForce(int[] intArr, int target) {
        int minLength = Integer.MAX_VALUE;

        for(int i= 0; i < intArr.length; i++) {
            int sum = 0;
            for (int j = i; j< intArr.length; j++ ) {
                sum += intArr[j];

                if(sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // no need to expand further
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private static int optimise(int[] intArr, int target) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < intArr.length; right++) {
            sum += intArr[right];

            // Shrink window as much as possible
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= intArr[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
