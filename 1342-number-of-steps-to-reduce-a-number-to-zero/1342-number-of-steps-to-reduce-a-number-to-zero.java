class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num != 0) {
            int isEven = num & 1;
            if(isEven == 1){
                num--;
            } else {
                num = num >> 1;
            }
            steps++;
        }
        return steps;
    }
}