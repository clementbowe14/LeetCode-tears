class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] > prices[i+1]){
                profit += (prices[i]-buy);
                buy = prices[i+1];
            }
        }
        profit+= prices[prices.length-1] - buy; 
        return profit; 
    }
}