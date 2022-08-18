class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int ans = Math.max(maxRobbery(nums, 0, nums.length-2), maxRobbery(nums, 1, nums.length-1));
        return ans;
    }
    public int maxRobbery(int[] nums, int start, int end) {
        int inc = 0;
        int ex = 0;
        for(int i = start; i <= end; i++) {
            int j = inc, e = ex;
            inc = e + nums[i];
            ex = Math.max(j, e);
        }
        return Math.max(inc, ex);
    }
}