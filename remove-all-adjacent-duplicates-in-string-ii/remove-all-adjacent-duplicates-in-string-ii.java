class Solution {
    public String removeDuplicates(String s, int k) {
        int c = 0;
        int []count = new int[s.length()];
        char [] stack = s.toCharArray();
        for(int i = 0; i < s.length(); i++, c++){
            stack[c] = stack[i];
            count[c] = c > 0 && stack[c-1] == stack[i] ? count[c-1] +1: 1;
            if(count[c] == k) c -= k;
        }
        return new String(stack, 0, c);
        
    }
}