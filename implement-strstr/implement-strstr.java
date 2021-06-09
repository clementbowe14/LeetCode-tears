class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        //this is getting the hash value of the string
        int needleHash = 0;
        int currentHash = 0;
        for(int i = 0; i < needle.length(); i++){
            int charValue = (int)needle.charAt(i);
            needleHash += charValue;
        }
        int left = 0; 
        int right = 0;
        
        while(right < haystack.length()){
            //finds the hash value of the substring size haystack
            while(right < haystack.length() && right - left < needle.length()){
                int currentLetter = (int)haystack.charAt(right);
                currentHash += currentLetter;
                right++;
            }
            if(currentHash == needleHash && haystack.substring(left, right).equals(needle)){
                return left;
            }
            
            int leftChar = (int)haystack.charAt(left);
            currentHash -= leftChar;
            left++;
        }
        
        return -1;
    }
}