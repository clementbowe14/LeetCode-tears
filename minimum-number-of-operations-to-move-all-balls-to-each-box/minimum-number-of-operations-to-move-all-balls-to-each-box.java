class Solution {
    public int[] minOperations(String boxes) {
        char [] boxValues = boxes.toCharArray();
        int [] ans = new int [boxValues.length];
        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < boxValues.length; j++) {
                if(i != j) {
                    if(boxValues[j] == '1') {
                        ans[i] += Math.abs(i-j);
                    }
                }
            }
        }
        return ans;
    }
}