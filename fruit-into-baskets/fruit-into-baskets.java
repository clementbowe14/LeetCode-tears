class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> fruitBaskets = new HashMap<>();
        int maximumFruits = Integer.MIN_VALUE;
        int currentFruits = 0;
        int i = 0;
        int j = 0;
        while(i < tree.length && j < tree.length){
            
            while(j < tree.length && fruitBaskets.size() < 3){
                int fruitType = tree[j];
                if(fruitBaskets.containsKey(fruitType) || (!fruitBaskets.containsKey(fruitType) && fruitBaskets.size() < 2)){
                    fruitBaskets.put(fruitType, fruitBaskets.getOrDefault(fruitType,0)+1);
                    currentFruits++;
                    maximumFruits = Math.max(currentFruits, maximumFruits);
                } else{
                    break;
                }
                j++;
            }
                
            fruitBaskets.put(tree[i], fruitBaskets.get(tree[i])-1);
            currentFruits--;
            if(fruitBaskets.get(tree[i]) < 1){
                fruitBaskets.remove(tree[i]);
            }
            i++;
            
        }
        return maximumFruits;
    }
}