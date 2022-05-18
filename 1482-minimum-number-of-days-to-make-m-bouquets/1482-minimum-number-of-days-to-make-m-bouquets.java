class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (m * k)) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(Integer i : bloomDay) {
            max = Math.max(i, max);
        }
        int left = 1;
        int right = max;
        
        while(left <= right) {
            int mid = (left + right) /2;
            if(makeBouqets(mid, bloomDay, k) < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    public int makeBouqets(int totalDays, int [] bloomDay, int k) {
        int count = 0;
        int b = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] > totalDays){
                b += (count / k);
                count = 0;
            } else {
                count++;
            }
        }
        
        if(count > 0) {
            b += (count/k);
        }
        return b;
    }
}