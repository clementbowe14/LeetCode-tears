class Solution {
    boolean [] visited = new boolean[200];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
  
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                ans++;
                dfs(isConnected, i);
            }
        }
        
        return ans;
    }
    
    public void dfs(int[][] isConnected, int node){
        
        visited[node] = true;
        for(int i = 0; i < isConnected[node].length; i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                
                dfs(isConnected, i);
            }
        }
       
    }
}