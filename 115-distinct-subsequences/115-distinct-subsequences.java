class Solution {
    
    int[][] cache;
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()){
            return 0;
        }
        
        if(s.length() == t.length()){
            return s.equals(t) ? 1 : 0;
        }
        
        cache = new int[s.length()][t.length()+1];
        for(int [] arr : cache){
            Arrays.fill(arr, -1);
        }
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(0)){
                res += dfs(s, t, i, 1);
            }
        }
        return res;
}
    
    public int dfs(String s, String t, int wordIndex, int index){
        if(index == t.length()){
            cache[wordIndex][index] = 1;
            return 1;
        }
        
        if(cache[wordIndex][index] != -1){
            return cache[wordIndex][index];
        }
        
        int ans = 0;
        
        char next = t.charAt(index);
        for(int i = wordIndex+1; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(currentChar == next){
                ans += dfs(s, t, i, index+1);
            }
        }
        
        cache[wordIndex][index] = ans;
        return ans;
    }
}
        
