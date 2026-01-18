package learning.concepts.arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] intArr1 = {2,3,-2,4};
        int[] intArr2 = {-2,0,-1};
        int[] intArr3 = null;
        int[] intArr4 = {-1};
        System.out.println(maxProduct(intArr4));
    }

    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for(int i=1; i< nums.length; i++) {
            if(nums[i] >= 0) {
                maxProduct = Math.max(maxProduct * nums[i],nums[i]);
                minProduct = Math.min(minProduct * nums[i],nums[i]);
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(nums[i], minProduct* nums[i] );
                minProduct = Math.min(nums[i], temp* nums[i] );
            }
            result = Math.max(result,maxProduct);
        }

        return result;
    }

    private static int maxProductAI(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static int maxProductOpt(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            int tempMax = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = tempMax;

            ans = Math.max(ans, max);
        }
        return ans;
    }

}
