class Solution {
    public int[] plusOne(int[] digits) {
        int start = digits.length-1;
        while(start >= 0) {
            digits[start]++;
            if(digits[start] == 10){
                digits[start] = 0;
                start--;
            } else{
                break;
            }
        }
        if(start < 0){
            digits = new int[digits.length+1];
            digits[0] = 1; 
        }
        return digits;
    }
}