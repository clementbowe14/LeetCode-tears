class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE-1; 
        int ans = 0;
        for(int i = 0; i < nums.length-2; i++){
            int lo = i+1;
            int hi = nums.length-1;
            int start = nums[i];
            while(lo < hi){
                int total = start+nums[lo]+nums[hi];
                if(Math.abs(target-closest) > Math.abs(target-total)){
                        closest = total;
                }
                if(total > target){
                    hi--;
                } else if(total < target){
                    lo++;
                }
                else{
                    return target;
                }
                }
        }
        return closest; 
    }
}