class Solution {
    /*
        starting from city zero the base cases are the cities already connected to city 0
        then for each city found that wasn't originally connected we add 1
        
    */
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        HashMap<Integer, Set<Integer>> edges = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            graph.add(new ArrayList<Integer>());
            edges.put(i, new HashSet<Integer>());
        }
        for(int[] connection : connections){
            int x = connection[0];
            int y = connection[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
            edges.get(x).add(y);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int totalChanges = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> neighbors = graph.get(node);
            visited[node] = true;
            for(int neighbor : neighbors){
                if(!visited[neighbor]){
                    if(!edges.get(neighbor).contains(node))
                        totalChanges++;
                    queue.add(neighbor);
                }
            }
        }
        return totalChanges;
        
    }
}