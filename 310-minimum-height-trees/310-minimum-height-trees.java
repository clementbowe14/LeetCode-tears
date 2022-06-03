class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return new ArrayList<Integer>(Arrays.asList(0));
        }
        int[] edgeCount = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> ans;
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for(int [] arr : edges){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
            edgeCount[arr[0]]++;
            edgeCount[arr[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < edgeCount.length; i++){
            if(edgeCount[i] == 1)
                queue.add(i);
        }
        
        while(n > 2){
            n -= queue.size();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                List<Integer> neighbors = graph.get(node);
                for(int j = 0; j < neighbors.size(); j++){
                    edgeCount[neighbors.get(j)]--;
                    if(edgeCount[neighbors.get(j)] == 1){
                        queue.add(neighbors.get(j));
                    }
                }
            }
        }
        
        ans = new ArrayList<>();
        while(!queue.isEmpty())
            ans.add(queue.poll());
        
        return ans;
    }
}