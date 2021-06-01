class Solution {
    //pretty sure this is more about detecting cycles than it is about topsorting
    // such a tease
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList <>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] memo = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(checkCycle(visited, memo, graph, i)){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkCycle(boolean [] recStack, boolean[] memo, List<List<Integer>> graph, int V){
        if(recStack[V]){
            return true;
        }
        if(memo[V]){
            return false;
        }
        
        recStack[V] = true;
        List<Integer> courses = graph.get(V);
        for(int i = 0; i < courses.size(); i++){
            if(checkCycle(recStack, memo, graph, courses.get(i))){
                return true;
            }
        }
        
        recStack[V] = false;
        memo[V] = true; 
        return false;
    }
}