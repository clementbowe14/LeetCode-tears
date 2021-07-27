class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != 0 ? 1 : 0;
        for(int i = 2; i <= n; i++){
            int onedigit = Integer.valueOf(s.substring(i-1, i));
            int twodigit = Integer.valueOf(s.substring(i-2, i));
            if(onedigit > 0 && onedigit < 10){
                dp[i] += dp[i-1];
            }
            if(twodigit >= 10 && twodigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}