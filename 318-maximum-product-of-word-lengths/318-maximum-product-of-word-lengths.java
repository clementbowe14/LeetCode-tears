class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        int [] values = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(char letter: words[i].toCharArray()){
                values[i] |= 1 << (letter -'a');
            }
        }
        
        for(int i = 0; i < values.length-1; i++){
            for(int j = i+1; j < values.length; j++){
                if((values[i] & values[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}