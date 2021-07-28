class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < manager.length; i++){
            if(manager[i] == -1){
                continue;
            }
            graph.get(manager[i]).add(i);
        }
        
        return lastPerson(graph, 0, headID, informTime);
    }
    
    public int lastPerson(List<List<Integer>> graph, int totalMinutes, int currentPerson, int [] informTime){
        if(graph.get(currentPerson).size() == 0){
            return totalMinutes;
        }
        
        int ans = totalMinutes;
        for(int i = 0; i < graph.get(currentPerson).size(); i++){
            ans = Math.max(ans, lastPerson(graph, totalMinutes + informTime[currentPerson], graph.get(currentPerson).get(i), informTime));
        }
        return ans;
        
    }
}