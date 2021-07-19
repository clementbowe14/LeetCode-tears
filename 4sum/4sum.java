class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> uniqueFourSums = new ArrayList<>();
        Arrays.sort(nums);
        fourSumHelper(nums, 0, 4, target, uniqueFourSums, new ArrayList<Integer>());
        return uniqueFourSums;
    }
    
    public void fourSumHelper(int[] nums, int currentIndex, int numberstoFind, int target, List<List<Integer>>uniqueFourSums, List<Integer> currentSumList){
        if(numberstoFind == 2){
        int leftPointer = currentIndex;
        int rightPointer = nums.length-1;
        while(leftPointer < rightPointer){
            int sum = nums[leftPointer] + nums[rightPointer];
            if(sum == target){
                
                currentSumList.add(nums[leftPointer]);
                currentSumList.add(nums[rightPointer]);
                uniqueFourSums.add(new ArrayList<Integer>(currentSumList));
                currentSumList.remove(currentSumList.size()-1);
                currentSumList.remove(currentSumList.size()-1);
                while(leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer+1])
                    leftPointer++;
                while(rightPointer > leftPointer && nums[rightPointer] == nums[rightPointer-1])
                    rightPointer--;
                
                rightPointer--;
                leftPointer++;
            }
            else if(sum < target){
                leftPointer++;
            }
            else {
                rightPointer--;
            }
        }
    
        }
        else{
            for(int i = currentIndex; i < nums.length; i++){
                if(i != currentIndex && nums[i] == nums[i-1])
                    continue;
                currentSumList.add(nums[i]);
                fourSumHelper(nums, i+1, numberstoFind-1, target-nums[i], uniqueFourSums, currentSumList);
                currentSumList.remove(currentSumList.size()-1);
            }
        }
    }
    
}