package learning.concepts.arrays;

public class BestTImeToBuySellStock {
    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,12};
        int[] prices2 = {7,6,5,3,2};
        System.out.println(maxProfitGenerate(prices2));
    }

    private static int maxProfitGenerate(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        int maxSellPrice = 0;
        for(int i = 0; i < prices.length; i++) {
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
            System.out.println("Iteraiton : "+i+" minPrice = "+minBuyPrice);
            maxSellPrice = prices[i];
            System.out.println("Iteraiton : "+i+" maxSellPrice = "+maxSellPrice);
            maxProfit = Math.max(maxSellPrice - minBuyPrice, maxProfit);
            System.out.println("Iteraiton : "+i+" maxProfit = "+maxProfit);
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minBuyPrice = Math.min(minBuyPrice, price);
            maxProfit = Math.max(maxProfit, price - minBuyPrice);
        }
        return maxProfit;
    }
}
