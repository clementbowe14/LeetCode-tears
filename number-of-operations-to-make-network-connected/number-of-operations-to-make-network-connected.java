class Solution {
    public int makeConnected(int n, int[][] connections) {
        int cycles = 0;
       
        UnionFind un = new UnionFind(n);
        for(int i = 0; i < connections.length; i++){
            // this finds the redundant connections
            if(!un.union(connections[i][0], connections[i][1])){
                cycles++;
            }
        }
        //so i already have cycles set to the number of redundant connections
        boolean valid = connections.length - (n-1) >= 0;
        if(valid)
            return cycles - (connections.length - (n-1));
        return -1; 
    }
    
    static class UnionFind {
        
        int [] parent;
        
        public UnionFind(int N){
            parent = new int[N];
        }
        
        public int find(int V){
            if(parent[V] <= 0){
                return V;
            }
            
            parent[V] = find(parent[V]);
            
            return parent[V];
        }
        
        public boolean union(int U, int V){
            
            int parentU = find(U);
            int parentV = find(V);
            
            if(parentU == parentV && parentU != 0){
                return false;
            }
            
            if(parent[parentU] < parent[parentV]){
                int min = parent[parentV] == 0 ? -1 :parent[parentV];
                parent[parentU] += min;
                parent[parentV] = parentU;
            }
            else {
                int min = parent[parentU] == 0 ? -1 : parent[parentU];
                parent[parentV] += min;
                parent[parentU] = parentV;
            }
            
            return true; 
            
        }
        
    }
}