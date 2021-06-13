class Solution {
    static class Pair{
        int weight; 
        int y; 
        int x; 
        public Pair(int w, int x, int y){
            weight = w;
            this.x = x;
            this.y = y; 
        }
    }
    public int minimumEffortPath(int[][] heights) {
        //set initial paths with minimum effort to max val
        int [][] effort = new int[heights.length][heights[0].length];
        for(int i = 0; i < effort.length; i++){
            for(int j = 0; j < effort[0].length; j++){
                effort[i][j] = Integer.MAX_VALUE; 
            }
        }
        
        //perform our dijkstra to get the first path that reaches the destination
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0, 1}};
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        heap.add(new Pair(0, 0, 0));
        effort[0][0] = 0; 
        
        
        while(!heap.isEmpty()){
            Pair p = heap.poll();
            int x = p.x;
            int y = p.y;
            int weight = p.weight;
            
            if(x == heights.length-1 && y == heights[0].length-1){
                return effort[x][y];
            }
            
            for(int i = 0; i < dirs.length; i++){
                if(x + dirs[i][0] >= 0 && x + dirs[i][0] < heights.length && y+dirs[i][1] >= 0 && y + dirs[i][1] < heights[0].length){
                    int newX = x + dirs[i][0];
                    int newY = y + dirs[i][1];
                    int newWeight = Math.max(weight, Math.abs(heights[newX][newY] - heights[x][y]));
                    if(newWeight < effort[newX][newY]){
                        effort[newX][newY] = newWeight;
                        heap.add(new Pair(newWeight, newX, newY));
                    }
                }
            }
        }
        return 0;
    }
}