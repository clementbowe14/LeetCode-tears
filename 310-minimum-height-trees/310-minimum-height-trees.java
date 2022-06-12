class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] in = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
            in[edge[1]]++;
        }
        
        for(int i = 0; i < n; i++){
            if(in[i] <= 1)
                queue.add(i);
        }
        
        int rem = n;
        
        while(rem > 2){
            int size = queue.size();
            rem -= size;
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                for(int val : graph.get(node)){
                    in[val]--;
                    if(in[val] == 1){
                        queue.add(val);
                    }
                }
            }
        }
        
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        
        return ans;
    }
}