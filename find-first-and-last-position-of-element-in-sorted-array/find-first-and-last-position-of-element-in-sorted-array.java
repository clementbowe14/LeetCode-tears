class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = -1;
        int rightIndex = -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] <= target){
                if(nums[mid] == target)
                    leftIndex = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        
        left = 0;
        right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target)
                    rightIndex = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return new int[] {rightIndex, leftIndex};
    }
}