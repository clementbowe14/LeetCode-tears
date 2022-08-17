class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodeLetters = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int res = 0;
        Set<String> set = new HashSet<>();
        for(String word : words) {
            String morseWord = "";
            for(char letter : word.toCharArray()){
                morseWord += morseCodeLetters[letter - 'a'];
            }
            if(set.add(morseWord)){
                res++;
            }
        }
        return res;
    }
}