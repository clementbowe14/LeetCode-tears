
/*
the amount of water the container can carry = Min(point1, point2) x dist(point1, point2)

*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(currentArea, max);
            if(height[left] > height[right]){
                right--;
            } else{
                left++;
            }
        }
        return max;
    }
}