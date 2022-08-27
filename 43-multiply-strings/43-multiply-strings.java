class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int [] sum = new int[num1.length() + num2.length()];
        for(int i = num1.length()-1; i >= 0; i--){
            for(int j = num2.length()-1; j >= 0; j--){
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                sum[i + j + 1] += x * y;
            }
        }
        
        for(int i = sum.length-1; i >= 0; i--){
            int val = (carry + sum[i]) % 10;
            carry = (carry + sum[i]) / 10;
            sum[i] = val;
        }
        
        for(int val : sum){
            res.append(val);
        }
        
        while(res.length() != 0 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        
        return res.length() == 0 ? "0" : res.toString();
    }
}