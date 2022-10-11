class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int [] timeTraveled = new int[garbage.length];
        int [] lastVisitedIndex = new int[3];
        int [] garbageCollectionTime = new int[3];
        for(int i = 1; i < garbage.length; i++) {
            timeTraveled[i] = timeTraveled[i-1] + travel[i-1];
        }
        
        for(int i = 0; i < garbage.length; i++){
            for(char letter : garbage[i].toCharArray()){
                if(letter == 'M') {
                    lastVisitedIndex[0] = i;
                    garbageCollectionTime[0]++;
                } else if(letter == 'G') {
                    lastVisitedIndex[1] = i;
                    garbageCollectionTime[1]++;
                } else {
                    lastVisitedIndex[2] = i;
                    garbageCollectionTime[2]++;
                }
            }
        }
        
        return timeTraveled[lastVisitedIndex[0]] + timeTraveled[lastVisitedIndex[1]] + timeTraveled[lastVisitedIndex[2]] + garbageCollectionTime[0] + garbageCollectionTime[1] + garbageCollectionTime[2];
    }
}