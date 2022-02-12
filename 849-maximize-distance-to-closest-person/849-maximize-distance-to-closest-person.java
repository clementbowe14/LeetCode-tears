class Solution {
    public int maxDistToClosest(int[] seats) {
        int last = -1;
        int dist = 0;
        int maxDist = 0;
        
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1){
                dist = last == -1? i : (i-last)/2;
                last = i;
            }
            maxDist = Math.max(dist, maxDist);
        }
        
        maxDist = Math.max(maxDist,  (seats.length-last)-1);
        
       return maxDist;
    }
}