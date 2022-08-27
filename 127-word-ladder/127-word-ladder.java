class Solution {
    
static class Pair {
        String word;
        int steps;
        public Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        PriorityQueue<Pair> pr = new PriorityQueue<>((a, b) -> a.steps-b.steps);
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String word : wordList){
            map.put(word, new ArrayList<String>());
        }
        
        if(!map.containsKey(beginWord)){
            map.put(beginWord, new ArrayList<String>());
            for(String word : wordList) {
                if(isTransformation(beginWord, word)){
                    map.get(beginWord).add(word);
                }
            }
        }
        
        for(int i = 0; i < wordList.size()-1; i++) {
            for(int j = i; j < wordList.size(); j++) {
                if(isTransformation(wordList.get(i), wordList.get(j))){
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        
        pr.add(new Pair(beginWord, 1));
        
        while(!pr.isEmpty()){

            Pair node = pr.poll();
                        
            if(visited.contains(node.word)){
                continue;
            }
            
            visited.add(node.word);
            
            if(node.word.equals(endWord))
                return node.steps;
            
            for(String word : map.get(node.word)) {
                if(!visited.contains(word)){
                    pr.add( new Pair(word, node.steps +1));
                }
            }
        }
            
            return 0;
        }
    
        public boolean isTransformation(String word1, String word2){
        int diff = 0;
        int idx = 0;
        for(char letter : word2.toCharArray()){
            if(letter != word1.charAt(idx++)){
                diff++;
            }
        }
        return diff == 1;
    }
        
}