class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        Stack<Integer> res = new Stack<>();
        boolean[] memo = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(hasCycle(graph, memo, recStack, i)){
                System.out.println("I returned true");
                return new int [] {};
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!recStack[i]){
                dfs(graph, recStack,res,i);
            }   
        }
        
        int [] ans = new int[res.size()];
        int c = 0;
        while(!res.isEmpty()){
            ans[c] = res.pop();
            c++;
        }
        return ans;
    }
    
    public boolean hasCycle(List<List<Integer>> graph, boolean[] memo, boolean[]visited, int V){
        if(visited[V]){
            return true;
        }
        if(memo[V]){
            return false;
        }
        visited[V] = true;
        List<Integer> adj = graph.get(V);
        for(int i = 0; i < adj.size(); i++){
            if(hasCycle(graph, memo, visited, adj.get(i))){
                return true;
            }
        }
        
        memo[V] = true;
        visited[V] = false;
        return false;
    }
    
    public void dfs(List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack, int V){
        if(visited[V]){
            return;
        }
        visited[V] = true;
        List<Integer> adj = graph.get(V);
        for(int i = 0; i < adj.size(); i++){
            if(!visited[adj.get(i)]){
                dfs(graph, visited, stack, adj.get(i));
            }
        }
        stack.push(V);
    }
}