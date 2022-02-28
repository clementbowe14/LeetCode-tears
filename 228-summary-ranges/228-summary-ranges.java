class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();
        
        if(nums.length == 1) {
            String res = nums[0] +"";
            ans.add(res);
            return ans;
        }
        
        for(int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while(i < nums.length-1 && nums[i]+1 == nums[i+1]) {
                i++;
            }
            
            if(start == nums[i]) {
                ans.add(start + "");
            } else {
                ans.add(start + "->" + nums[i]);
            }
            
        }
        
        return ans;
    }
}