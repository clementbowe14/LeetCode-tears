class Solution {
    //eat tea tan ate nat bat
    // bat nat tan ate eat tea
    // sort the letters of each word
    // add the word in the position of its sorted version
    // iterate through each list of words
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        String[] sortedWords = new String[strs.length];
        int idx = 0;
        
        for(String word : strs) {
            char[] oldWord = word.toCharArray();
            Arrays.sort(oldWord);
            sortedWords[idx] = String.valueOf(oldWord);
            map.put(sortedWords[idx], new ArrayList<String>());
            idx++;
        }
        
        for(int i = 0; i < strs.length; i++) {
            map.get(sortedWords[i]).add(strs[i]);
        }
        
        for(String key : map.keySet()){
            List<String> words = map.get(key);
            ans.add(new ArrayList<>(words));
        }
        return ans;
    }
}