class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.containsKey(num-1) ? map.get(num-1) : 0;
                int right = map.containsKey(num+1) ? map.get(num+1) : 0;
                int sum = left + right + 1;
                map.put(num, sum);
                ans = Math.max(sum, ans);
                map.put(num + right, sum);
                map.put(num - left, sum);
            } else {
                continue;
            }
        }
        return ans;
    }
}