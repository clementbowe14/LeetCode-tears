class Solution {
    public int missingNumber(int[] nums) {
        int sumOfArray = 0;
        int sumOfRange = 0;
        for(int i = 0; i <= nums.length; i++){
            if(i < nums.length)
                sumOfArray += nums[i];
            sumOfRange += i;
        }
        return sumOfRange - sumOfArray;
    }
}