class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrows = 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int end = -1;
        for(int i = 0; i < points.length; i++) {
            if(i == 0 || points[i][0] > end){
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}