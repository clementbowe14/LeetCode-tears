public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count= 0;
        String bits = Integer.toBinaryString(n);
        for(Character c : bits.toCharArray()) {
            if(c == '1')
                count++;
        }
        return count;
    }
}