class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        dfs(paths, ans, graph, 0);
        return ans;
    }
    public void dfs(List<Integer> path, List<List<Integer>> ans, int[][] graph, int row){
        if(row == graph.length-1){
            ans.add(path);
            return;
        }
        for(int i = 0; i < graph[row].length; i++){
            path.add(graph[row][i]);
            dfs(new ArrayList<>(path), ans, graph, graph[row][i]);
            path.remove(path.size()-1);
        }
        return;
    }
}