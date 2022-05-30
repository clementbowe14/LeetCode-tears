class Solution {
    public int longestValidParentheses(String s) {
        int [] dp = new int[s.length()];
        int ans = 0;
        for(int i = 1; i < s.length(); i++){
            char current = s.charAt(i);
            char prev = s.charAt(i-1);
            if(current == ')' && prev == '('){
                dp[i] = i-2 >= 0 ? 2 + dp[i-2] : 2;
            } else if(current == ')' && prev == ')'){
                int prevSequence = i - dp[i-1] - 2 >= 0 ? i - dp[i-1] - 2 : 0;
                boolean isOpen = i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] -1) == '(';
                if(isOpen)
                    dp[i] = 2 + dp[i-1] + dp[prevSequence];
            }
            // System.out.println(dp[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}