class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1 ) {
            return 0;
        }
        int max = 0;
        int currentMin = prices[0];
        for(int i = 0; i < prices.length; i++) {
            max = Math.max(prices[i] - currentMin, max);
            currentMin = Math.min(currentMin, prices[i]);
        }
        return max;
    }
}