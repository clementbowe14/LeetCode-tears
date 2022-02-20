class Solution {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pr = new PriorityQueue<>((a, b) -> b-a);
        int ans = Integer.MAX_VALUE;
            
        for(int i : nums) {
            int num = i;
            if(num % 2 == 1) 
                num *= 2;
            min = Math.min(num, min);
            pr.add(num);
        }
        
        while(pr.peek() % 2 == 0) {
            int max = pr.poll();
            ans = Math.min(ans, max-min);
            min = Math.min(min, max/2);
            pr.add(max/2);
        }
        
        return Math.min(ans, pr.peek()-min);
    }
}