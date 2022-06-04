class Solution {
    public int shortestPathLength(int[][] graph) {
        if(graph.length == 1)
            return 0;
        int n = graph.length;
        int end = (1 << n)-1;
        boolean[][] seen = new boolean[graph.length][end];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.add(new int[]{i, 1 << i, 0});
        }
        
        while(!queue.isEmpty()){
            int [] node = queue.poll();
            int curr = node[0];
            int mask = node[1];
            int steps = node[2];
            for(int val : graph[node[0]]){
                int nextState = mask | 1 << val;
                int nextSteps = 1 + steps;
                if(nextState == end)
                    return nextSteps;
                if(!seen[val][nextState]){
                    seen[val][nextState] = true;
                    queue.add(new int[]{val, nextState, nextSteps});
                }
                
            }
        }
        
        return -1;
    }
}