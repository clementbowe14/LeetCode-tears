class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num ==1 ){
            return true; 
        }
        int left = 1;
        int right = num;
        
        while(left <= right){
          int mid = left + (right - left) / 2;
            System.out.println(mid);
            if(num/mid > mid){
                left = mid+1;
            }
            else if(num/mid < mid){
                right = mid-1;
            }
            else{
                return squareNum(num, mid);
            }
        }
        
        return false;
    }
    
    public boolean squareNum(int num, int val){
        if(num == 1){
            return true;
        }
        
        if(num % val != 0){
            return false;
        }
        
        return squareNum(num/val, val);
    }
}