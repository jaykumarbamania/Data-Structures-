package learning.concepts.arrays;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] intArr1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] intArr2 = {1};
        int[] intArr3 = {5,4,-1,7,8};
        System.out.println(maxSubArray(intArr3));

    }

    private static int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int sum = 0;
        for(int i=0; i< nums.length; i++) {
            sum += nums[i];
            if(sum > maxSoFar) maxSoFar = sum;
            if (sum < 0) sum = 0;
        }
        return maxSoFar;
    }

    public int maxSubArrayLC(int[] nums) {
        int currentSum = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}
