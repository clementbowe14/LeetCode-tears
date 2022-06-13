class Solution {
    int[][] cache;
    boolean[][] visited;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        cache = new int[triangle.size()][triangle.get(n-1).size()];
        visited = new boolean[triangle.size()][triangle.get(n-1).size()];
        int ans = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < triangle.get(n-1).size(); i++){
            ans = Math.min(ans, dfs(triangle, n-1, i));
        }
        return ans;
    }
  public int  dfs(List<List<Integer>> triangle, int row, int col){
        if(row == 0){
            return triangle.get(row).get(col);
        }
        
        if(visited[row][col]){
            return cache[row][col];
        }
        
        int left = col - 1 >= 0 ? dfs(triangle, row-1, col-1) : Integer.MAX_VALUE;
        int right = col < triangle.get(row-1).size() ? dfs(triangle, row-1, col) : Integer.MAX_VALUE;
        
        int ans = Math.min(left, right) + triangle.get(row).get(col);
        cache[row][col] = ans;
        visited[row][col] = true;
        
        return ans;
    }
}