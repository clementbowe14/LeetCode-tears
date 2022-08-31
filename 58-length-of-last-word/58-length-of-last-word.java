class Solution {
    public int lengthOfLastWord(String s) {
        String word = s.trim();
        int index = s.length()-1;
        int ans = 0;
        while(index >= 0 && Character.isWhitespace(s.charAt(index))){
            index--;
        }
        
        while(index >= 0 && !Character.isWhitespace(s.charAt(index))){
            index--;
            ans++;
        }
        
        return ans;
    }
}