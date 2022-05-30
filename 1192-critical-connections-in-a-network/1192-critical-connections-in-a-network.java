class Solution {
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(List<Integer> connection : connections){
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        
        boolean[] visited = new boolean[n];
        int[] lowlink = new int[n];
        int [] id = new int[n];
        dfs(0, visited, lowlink, ans, graph, id, 0,  100000);
        
        return ans;
    }
    
    public void dfs(int index, boolean[] visited, int[] lowlink, List<List<Integer>> ans, Map<Integer, List<Integer>> graph, int [] id, int currentId, int previousValue) {
        visited[index] = true;
        id[index] = lowlink[index] = currentId;
        List<Integer> neighbors = graph.get(index);
        for(Integer neighbor : neighbors) {
            if(neighbor == previousValue)
                continue;            
            if(!visited[neighbor]){
                dfs(neighbor, visited, lowlink, ans, graph, id, currentId+1, index);
            }
            lowlink[index] = Math.min(lowlink[neighbor], lowlink[index]);
            
            if(lowlink[neighbor] == 1 + currentId){
                ans.add(Arrays.asList(index, neighbor));
            }
        }
    }
}