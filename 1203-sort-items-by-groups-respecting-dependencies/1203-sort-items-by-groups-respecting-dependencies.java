class Solution {
    boolean canSort;    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> items = new ArrayList<>();
        List<List<Integer>> groups = new ArrayList<>();
        List<List<Integer>> groupsToItems = new ArrayList<>();
        List<Integer> sortedItems = new ArrayList<>();
        List<Integer> sortedGroups = new ArrayList<>();
        int [] ans = new int[n];
        canSort = true;
        
        
        for(int i = 0; i < group.length; i++){
            if(group[i] == -1){
                group[i] = m++;
            }
            items.add(new ArrayList<>());
        }
        
       for(int i = 0; i < m; i++){
           groups.add(new ArrayList<>());
           groupsToItems.add(new ArrayList<>());
       }
        
        for(int i = 0; i < n; i++){
            List<Integer> neighbors = beforeItems.get(i);
            for(int neighbor : neighbors){
                if(group[neighbor] != group[i]){
                    groups.get(group[i]).add(group[neighbor]);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            List<Integer> neighbors = beforeItems.get(i);
            for(int neighbor : neighbors){
                items.get(i).add(neighbor);
            }
        }
        
        boolean[] onStackGroups = new boolean[m];
        boolean[] visitedItems = new boolean[n];
        boolean[] visitedGroups = new boolean[m];
        boolean[] onStackItems = new boolean[n];
        
        for(int i = 0; i < m; i++) {
            if(!visitedGroups[i]){
                dfs(i, groups, sortedGroups, visitedGroups, onStackGroups);
                if(!canSort){
                    return new int[]{};
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!visitedItems[i]){
                dfs(i, items, sortedItems, visitedItems, onStackItems);
            }
            if(!canSort){
                return new int[]{};
            }
        }
        
        for(int i = 0; i < n; i++){
                groupsToItems.get(group[sortedItems.get(i)]).add(sortedItems.get(i));
        }
        
        int idx = 0;
        for(int i = 0; i < m; i++){
            List<Integer> lst = groupsToItems.get(sortedGroups.get(i));
            for(int item : lst){
                ans[idx++] = item;
            }
        }
        
        return ans;
            
    }
    
    public void dfs(int index, List<List<Integer>> graph, List<Integer> topSort, boolean[] visited, boolean[] onStack){
        if(visited[index])
            return;
        
        onStack[index] = true;
        List<Integer> neighbors = graph.get(index);
        for(int neighbor : neighbors){
            if(onStack[neighbor]){
                canSort = false;
                break;
            }
            
            dfs(neighbor, graph, topSort, visited, onStack);
        }
        
        onStack[index] = false;
        topSort.add(index);
        visited[index] = true;
    }
    
    
}