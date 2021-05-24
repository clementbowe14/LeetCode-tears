class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(divisorResult(mid, nums) > threshold){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    
    public int  divisorResult(int mid, int[] nums){
        int sum = 0;
        
        for(int num : nums){
            int div = num/mid;
            int rem = num % mid == 0 ? 0 : 1;
            
            sum += (div + rem);
        }
        
        return sum; 
    }
}