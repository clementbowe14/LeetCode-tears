class Solution {
    //pair will store the place we're visiting and t
    static class Pair{
        double chance;
        int x;
        public Pair(double c, int x){
            chance = c;
            this.x = x;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        Map<Integer, Double> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Pair>());
            map.put(i, 0.0);
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(new Pair(succProb[i], edges[i][1]));
            graph.get(edges[i][1]).add(new Pair(succProb[i], edges[i][0]));
        }
        
        //hopefully this works >_< i really googled for this
        PriorityQueue<Pair> pr = new PriorityQueue<>(Collections.reverseOrder((a, b) -> Double.compare(a.chance, b.chance))); 
        pr.add(new Pair(1, start));
        map.put(start, 1.0);
        
        //thought process 
        // keep track of the success probability
        // whenever the edge gets a higher probability of success add it to the pq
        while(!pr.isEmpty()){
            Pair pair = pr.poll();
            int loc = pair.x;
            double prob = pair.chance;
            
            if(loc == end)
                return map.get(end);
            
            for(int i = 0; i < graph.get(loc).size(); i++){
                int newLoc = graph.get(loc).get(i).x;
                double currentProb = graph.get(loc).get(i).chance;
                double newprob = prob * currentProb; 
                if(newprob > map.get(newLoc)){
                    map.put(newLoc, newprob);
                    pr.add(new Pair(newprob, newLoc));
                }
            }
        }
        return map.get(end);
    }
                   
}