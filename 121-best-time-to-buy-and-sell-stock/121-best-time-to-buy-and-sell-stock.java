class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1 ) {
            return 0;
        }
        
        int max = 0;
        int currentMin = prices[0];
        for(Integer price : prices) {
            max = Math.max(price - currentMin, max);
            currentMin = Math.min(price, currentMin);
        }
        return max;
    }
}