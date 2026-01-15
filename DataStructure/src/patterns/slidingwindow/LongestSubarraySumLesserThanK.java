package patterns.slidingwindow;


class LongestSubarraySumLesserThanK {

    public static void main(String[] args) {
        int[] intArr = new int[]{2,1,5,1,3,2};
        int k = 8;
        System.out.println(optimise(intArr, k));
    }

    private static int bruteForce(int[] intArr, int size) {
        int maxLength = 0;
        for(int i = 0; i<= intArr.length; i++){
            int sum = 0;
            for(int j=i; j< intArr.length; j++){
                sum += intArr[j];

                if( sum <= size) {
                    maxLength = Math.max(maxLength, j - i +1);
                }
            }
        }
        return maxLength;
    }

    private static int optimise(int[] intArr, int size) {
        int maxLength = 0;
        int sum = 0;
        int left = 0;
        for(int right = 0; right< intArr.length; right++){
            sum += intArr[right];
            if( sum > size) {
                sum -= intArr[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }
}