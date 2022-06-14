class Solution {
    
    public void topSort(List<List<Integer>> graph, int[] indegree, List<Integer> order){
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
                int node = queue.poll();
                order.add(node);
                for(int val: graph.get(node)){
                    indegree[val]--;
                    if(indegree[val] == 0)
                        queue.add(val);
                }
            }
            
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer> groupOrder = new ArrayList<>();
        List<Integer> itemOrder = new ArrayList<>();
        List<List<Integer>> groupToItemOrder = new ArrayList<>();
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        
        for(int i = 0; i < group.length; i++){
            if(group[i] == -1){
                group[i] = m++;
            }
        }
        
        for(int i = 0; i < m; i++){
            groupGraph.add(new ArrayList<>());
            groupToItemOrder.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            itemGraph.add(new ArrayList<>());
        }
        
        int[] itemDegree = new int[n];
        int [] groupDegree = new int[m];
        
        int idx = 0;
        for(List<Integer> items : beforeItems){
            for(int item : items){
                itemGraph.get(item).add(idx);
                itemDegree[idx]++;
            }
            idx++;
        }
        
        for(int i = 0; i < group.length; i++){
            int targetGroup = group[i];
            for(int item : beforeItems.get(i)){
                if(group[item] != targetGroup){
                    groupGraph.get(group[item]).add(targetGroup);
                    groupDegree[targetGroup]++;
                }
            }
        }
        
        topSort(groupGraph, groupDegree, groupOrder);
        topSort(itemGraph, itemDegree, itemOrder);
        
        if(itemOrder.size() < n || groupOrder.size() < m){
            return new int[]{};
        }
        
        for(int i = 0; i < itemOrder.size(); i++){
            groupToItemOrder.get(group[itemOrder.get(i)]).add(itemOrder.get(i));
        }
        int [] ans = new int[n];
        idx = 0;
        for(int groups: groupOrder){
            for(int item : groupToItemOrder.get(groups)){
                ans[idx++] = item;
            }
        }
        return ans;
    }
}