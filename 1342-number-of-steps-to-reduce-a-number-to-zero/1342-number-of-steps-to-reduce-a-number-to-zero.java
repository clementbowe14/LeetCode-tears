class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num != 0) {
            int isEven = num & 1;
            num = isEven == 0 ? num >> 1 : num-1;
            steps++;
        }
        return steps;
    }
}