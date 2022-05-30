class Solution {
    public int maxProduct(String[] words) {
        int [] masks = new int[words.length];
        int idx = 0;
        int ans = 0;
        for(String word : words){
            for(char letter : word.toCharArray()){
                masks[idx] |= 1 <<(letter-'a');
            }
            idx++;
        }
        for(int i = 0; i < masks.length-1; i++){
            for(int j = i+1; j < masks.length; j++){
                if((masks[i] & masks[j]) == 0)
                    ans = Math.max(words[i].length()*words[j].length(), ans);
            }
        }
        
        return ans;
    }
}