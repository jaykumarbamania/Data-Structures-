package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeSlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxArrSum(arr, k));
    }

    private static int maxArrSum(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // Step 1: Add current element to window
            windowSum += nums[i];

            // Step 2: When window reaches size k
            if (i >= k - 1) {
                // Update max sum
                maxSum = Math.max(maxSum, windowSum);

                // Step 3: Remove element going out of window
                windowSum -= nums[i - (k - 1)];
            }
        }
        return maxSum;
    }
}