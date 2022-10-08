class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i = 0; i < nums.length-2; i++){
            int start = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int currentSum = start + nums[left] + nums[right];
                if(currentSum > target){
                    right--;
                } else {
                    left++;
                }
                ans = minDiff > Math.abs(currentSum - target) ? currentSum : ans;
                minDiff = Math.min(minDiff, Math.abs(currentSum - target));
            }
        }
        
        return ans;
    }
}