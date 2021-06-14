class Solution {
    // djikstras
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create adj graph
        // < from , <to, cost> >
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int i = 0; i < n; i++){
            graph.put(i, new HashMap());
        }
        // build adjacency list
        for (int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];
            graph.get(u).put(v, c);
        }
        
        // use djikstras algo, heap for destination, cost to now, and flights taken
        // u, cost, totalFlights taken (which is 1 more than total stops)
        // ascending by cost
        int[][] costs = new int[n][2];
        for (int[] row : costs){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet();
        // cost to get to src is 0
        heap.offer(new int[]{src, 0, 0});
        
        while (!heap.isEmpty()){
            int[] curr = heap.poll();
            int u = curr[0];
            if (curr[2] > k + 1){
                continue;// need to unset the direction we came from  
            } 
            if (curr[1] < costs[u][0] || curr[2] < costs[u][1]){
                costs[u][0] = curr[1];
                costs[u][1] = curr[2];
            }
            // skip nodes we already completely explored
            // if (visited.contains(curr[0])){
            //     continue;
            // } 
            // found a valid path
            if (curr[0] == dst && curr[2] <= k + 1){
                return curr[1];
            }
            // visited.add(curr[0]);
            Map<Integer, Integer> neighbours = graph.get(curr[0]);
            for (Map.Entry<Integer, Integer> ent : neighbours.entrySet()){
                int v = ent.getKey();
                int[] toGo = new int[]{v, ent.getValue() + curr[1], 1 + curr[2]};
                // go to it if we have either we can reduce our count, or we have a path that takes less
                if (toGo[1] < costs[v][0] || toGo[2] < costs[v][1]){
                    heap.add(toGo);
                }
            }
        }
        return -1;
    }
}