class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int [] dp = new int[envelopes.length];
        int idx = 0;
        int foldLoc = 0;
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });
        
        for(int [] envelope : envelopes) {
            int pos = Arrays.binarySearch(dp, 0, foldLoc, envelope[1]);
            if(pos < 0)
                pos = -(pos + 1);
            dp[pos] = envelope[1];
            if(pos == foldLoc)
                foldLoc++;
            
        }
        
        return foldLoc;
    }
    

}