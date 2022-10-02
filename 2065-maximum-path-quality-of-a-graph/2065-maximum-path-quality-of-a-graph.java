class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], t -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], t -> new HashMap<>()).put(edge[0], edge[2]);
        }
        
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        return dfs(graph, values, 0, maxTime, Set.of(0));
    }
    
    private int dfs(Map<Integer, Map<Integer, Integer>> graph, int[] values, int current, int time, Set<Integer> seen) {
        if (time < 0) return 0;
            
        int result = 0;
        if (current == 0) {
            for (int i : seen)
                result += values[i];
        }
        
        if (!graph.containsKey(current)) return result;
        
        for (Map.Entry<Integer, Integer> edge : graph.get(current).entrySet()) {
            int restTime = time - edge.getValue();
            if (restTime < 0) continue;
            
            Set<Integer> newSeen = new HashSet<>(seen);
            newSeen.add(edge.getKey());
            
            int newResult = dfs(graph, values, edge.getKey(), restTime, newSeen);
            result = Math.max(result, newResult);
        }
        
        return result;
    }
}