class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int res = 0;
        int[] it = {-1, -1};
        
        for(int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if( x > it[0] && y > it[1]) {
                it[0] = intervals[i][0];
                res++;
            } 
                it[1] = Math.max(it[1], intervals[i][1]);
        }
        
        return res;
    }
}