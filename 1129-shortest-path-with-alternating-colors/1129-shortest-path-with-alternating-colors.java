class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redGraph = new HashMap<>();
        Map<Integer, List<Integer>> blueGraph = new HashMap<>();
        int [] red = new int[n];
        int [] blue = new int[n];
        Arrays.fill(red, Integer.MAX_VALUE/2);
        Arrays.fill(blue, Integer.MAX_VALUE/2);
        int [] dp = new int[n];

        red[0] = 0;
        blue[0] = 0;
        
        for(int i = 0; i < n; i++){
            redGraph.put(i, new ArrayList<Integer>());
            blueGraph.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < redEdges.length; i++){
            redGraph.get(redEdges[i][0]).add(redEdges[i][1]);
        }
        
        for(int i = 0; i < blueEdges.length; i++){
            blueGraph.get(blueEdges[i][0]).add(blueEdges[i][1]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int index = node[0];
            int currentColor = node[1];
            
            List<Integer> neighbor = 1 - currentColor == 0 ? redGraph.get(index) : blueGraph.get(index);
            int[] prev = currentColor == 0 ? red: blue;
            int[] curr = 1 - currentColor == 0 ? red : blue;
            
            for(int i = 0; i < neighbor.size(); i++){
                int nextIndex = neighbor.get(i);
                int nextColor = 1 - currentColor;
                if(prev[index] +1 < curr[nextIndex]){
                    curr[nextIndex] = 1 + prev[index];
                    queue.add(new int[]{nextIndex, nextColor});
                }
            }
        }
        
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = Math.min(red[i], blue[i]);
            if(dp[i] == Integer.MAX_VALUE/2)
                dp[i] = -1;
        }
        
        return dp;
    }
}