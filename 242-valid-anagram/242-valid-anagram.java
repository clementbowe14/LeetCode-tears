class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] sLetters = new int[26];
        int[] tLetters = new int[26];
        for(int i = 0; i < s.length(); i++){
            sLetters[s.charAt(i)-'a']++;
            tLetters[t.charAt(i)-'a']++; 
        }
        
        for(int i = 0; i < 26; i++){
            if(sLetters[i] != tLetters[i]){
                return false;
            }
        }
        return true;
    }
}