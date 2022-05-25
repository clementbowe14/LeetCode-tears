class Solution {
    
    boolean[] check;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        check = new boolean[graph.length];
        boolean[] visited = new boolean[n];
        boolean[] cycle = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(!check[i]){
                dfs(graph, cycle, visited, i);
            }
            
            if(!cycle[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    
    public void dfs(int[][] graph, boolean[] cycle, boolean[] visited, int index) {
        if(visited[index]) {
            cycle[index] = true;
            return;
        }
        
        if(check[index])
            return;
        
        check[index] = true;
        visited[index] = true;
        
        for(int neighbor: graph[index]){
            dfs(graph, cycle, visited, neighbor);
            if(cycle[neighbor]){
                cycle[index] = true;
            }
        }
        
        visited[index] = false;
    }
}