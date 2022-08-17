class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int ans;
        if(cost.length < 2){
            return 0;
        } else if(cost.length == 2){
            ans = Math.min(cost[0], cost[1]);
        } else {
            int[] res = new int[cost.length];
            res[0] = cost[0];
            res[1] = cost[1];
            for(int i = 2; i < cost.length; i++) {
                res[i] = cost[i] + Math.min(res[i-1], res[i-2]);
            }
            ans = Math.min(res[res.length-1], res[res.length-2]);
        }
        return ans;
    }
}