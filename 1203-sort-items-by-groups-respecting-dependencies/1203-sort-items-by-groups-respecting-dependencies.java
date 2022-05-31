class Solution {
    
    boolean canTopSort = true;
    boolean[] onGroupStack;
    boolean[] onItemStack;
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groups = new ArrayList<>();
        List<List<Integer>> items = new ArrayList<>();
        List<List<Integer>> groupsToItemsOrder = new ArrayList<>();
        int[] ans = new int[n];
        
        int loc = 0;
        for(int i : group){
            if(i == -1){
                group[loc] = m;
                m++;
            }
            loc++;
        }
        
        boolean [] groupsVisited = new boolean[m];
        boolean[] itemsVisited = new boolean[n];
        onGroupStack = new boolean[m];
        onItemStack = new boolean[n];
        
        for(int i = 0; i <= m; i++){
            groupsToItemsOrder.add(new ArrayList<>());
            groups.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            items.add(new ArrayList<Integer>());
        }
        
        //create group graph
        for(int i = 0; i < group.length; i++){
            List<Integer> neighbors = beforeItems.get(i);
            for(int neighbor : neighbors){
                if(group[neighbor] != group[i])
                    groups.get(group[i]).add(group[neighbor]);
            }
        }
        
        //create item graph
        for(int i = 0; i < n; i++){
            List<Integer> neighbors = beforeItems.get(i);
            for(int neighbor : neighbors){
                items.get(i).add(neighbor);
            }
        }
        
        List<Integer> groupsOrdering = new ArrayList<>();
        List<Integer> itemsOrdering = new ArrayList<>();
        
        //topSort groups
        for(int i = 0; i < m; i++){
            if(!groupsVisited[i]){
                dfs(i, groups, groupsOrdering, groupsVisited, onGroupStack);
            }
        }
        
        if(!canTopSort)
            return new int[]{};
        
        for(int i = 0; i < n; i++){
            if(!itemsVisited[i]){
                dfs(i, items, itemsOrdering, itemsVisited, onItemStack);
            }
        }
        
        if(!canTopSort)
            return new int[]{};
        
        for(int item : itemsOrdering){
            groupsToItemsOrder.get(group[item]).add(item);
        }
        
        int idx = 0;
        for(int g : groupsOrdering){
            for(int i : groupsToItemsOrder.get(g))
                ans[idx++] = i;
        }
        
        return ans;  
    }
    
    public void dfs(int index, List<List<Integer>> graph, List<Integer> ordering, boolean[] visited, boolean[] onStack){
        if(onStack[index]){
            return;
        }
        
        if(visited[index]){
            canTopSort = false;
            return;
        }
        
        visited[index] = true;
        for(int neighbor : graph.get(index)){
            dfs(neighbor, graph, ordering, visited, onStack);
        }
        
        if(canTopSort){
            onStack[index] = true;
            ordering.add(index);
        }
        
        visited[index] = false;
    }
}