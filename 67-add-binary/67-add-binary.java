class Solution {
    public String addBinary(String a, String b) {
        int rem = 0;
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0  && j >= 0) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(j) - '0';
            int sum = x + y + rem;
            rem = sum / 2;
            sum = sum % 2;
            res.append(sum);
            i--;
            j--;
        }
        while(i >= 0){
            int sum = (a.charAt(i) - '0') + rem;
            rem = sum/2;
            sum = sum % 2;
            res.append(sum);
            i--;
        }
        while(j >= 0){
            int sum = (b.charAt(j) - '0') + rem;
            rem = sum / 2;
            sum = sum % 2;
            res.append(sum);
            j--;
        }
        
        if(rem > 0)
            res.append(rem);
        
        
        return res.reverse().toString();
    }
}