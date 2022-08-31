class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length < 2)
            return nums[0];
        
        int ans = Integer.MIN_VALUE;
        int curr = 0;
        for(int num : nums){
            curr = Math.max(num, curr + num);
            ans = Math.max(curr, ans);
        }
        return ans;
    }
}