class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        
        for(int key: map.keySet()){
            queue.add(map.get(key));
        }
        int total = 0;
        int count = 0;
        while(count < arr.length/2){
            count += queue.poll();
            total++;
        }
        return total;
    }
}