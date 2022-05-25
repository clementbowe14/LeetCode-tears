class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int keyCount = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            List<Integer> neighbors = rooms.get(node);
            for(int neighbor : neighbors) {
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    keyCount++;
                    queue.add(neighbor);
                }
            }
        }
        

        
        return keyCount == rooms.size();
    }
}