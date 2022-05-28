class Solution {
    int[] lowlink;
    int[] id;
    boolean[] onStack;
    boolean[] visited;
    List<List<Integer>> res;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        lowlink = new int[n];
        id = new int[n];
        onStack = new boolean[n];
        visited = new boolean[n];
        Arrays.fill(id, -1);
        res = new ArrayList<>();
    
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());
        
        for(List<Integer> conn : connections){
            int U = conn.get(0);
            int V = conn.get(1);
            graph.get(U).add(V);
            graph.get(V).add(U);
        }
        
        dfs(0, graph, 0,  -1);
        
        return res;
    }
    
    public void dfs(int index, List<List<Integer>> graph, int rank, int previousValue){
        onStack[index] = true;
        visited[index] = true;
        id[index] = lowlink[index] = rank;
        
    
        List<Integer> adj = graph.get(index);
        for(int node : adj){
            if(node == previousValue)
                continue;
            
            if(!visited[node]){
                dfs(node, graph, rank+1, index);
            }
            
            lowlink[index] = Math.min(lowlink[node], lowlink[index]);
            
            if(lowlink[node] >= rank+1){
                res.add(new ArrayList(Arrays.asList(index, node)));
            }
        }
    }
}