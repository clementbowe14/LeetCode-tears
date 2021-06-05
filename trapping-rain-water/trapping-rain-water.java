class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        int leftmax = Integer.MIN_VALUE;
        int rightmax = Integer.MIN_VALUE;
        while(left < right){
            leftmax = Math.max(height[left], leftmax);
            rightmax = Math.max(height[right], rightmax);
            if(leftmax <= rightmax){
                ans += leftmax-height[left];
                left++;
            }
            else{
                ans += rightmax - height[right];
                right--;
            }
        }
        return ans; 
    }
}