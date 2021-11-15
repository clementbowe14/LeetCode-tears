class Solution {
    
    Map<String, Integer> cache = new HashMap<>();
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        Map<String, List<String>> chains = new HashMap<>();
        
        for(int i = 0; i < words.length-1; i++){
            chains.put(words[i], new ArrayList<String>());
            for(int j = i+1; j < words.length; j++) {
                
              if(isChain(words[i], words[j]) && !words[i].equals(words[j])){
                  System.out.println(words[i] + " " + words[j]);
                  chains.get(words[i]).add(words[j]);
              }
            }
        }
        
        int ans = 0;
        
        for(String word : words) {
            ans = Math.max(ans, longestChain(chains, 1,  word));
        }
        
        return ans;
    }
    
    public int longestChain(Map<String, List<String>> chain, int currentChain, String currentWord) {
        
        if(cache.containsKey(currentWord)) {
            return cache.get(currentWord);
        }
        
        List<String> next = chain.getOrDefault(currentWord, new ArrayList<>());
        int maxChain = currentChain;
        for(int i = 0; i < next.size(); i++) {
            maxChain = Math.max(maxChain, longestChain(chain, currentChain+1, next.get(i)));
        }
        
        cache.put(currentWord, maxChain);
        
        return maxChain;
        
    } 
    
    public boolean isChain(String a, String b){
        
        if(a.length() == b.length() || Math.abs(a.length()-b.length()) > 1){
            return false;
        }
        
        int i = 0;
        int j = 0;
        int currdiff = 0;
        
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) != b.charAt(j)) {
                currdiff++;
                j++;
            } else {
                i++;
                j++;
            }
            if(currdiff > 1){
                return false;
            }

        }
        
        return true;
    }
}