class Solution {
    /**
    currentSatisfiedwithTechnique
    satisfiedCustomerswithoutTechnique
    maxSatisfiedWithTechnique
    while(left < customers.length)
        while(right < customers.length && left < minutes)
            if grumpy[right] == 1
                currentSatisfiedwithTechnique+= customers[i]
            
        maxSatisfiedWithTechnique = max(currentSatisfiedwithTechnique, maxSatisfiedWithTechnique)
    
    
    
    */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i = 0;
        int j = 0;
        int currentSatisfiedWithTechnique = 0;
        int maxSatisfiedWithTechnique = Integer.MIN_VALUE;
        int satisfiedCustomersWithoutTechnique = 0;
        while(i < customers.length){
            int techniqueStart = i;
            int techniqueEnd = j; 
            while(techniqueEnd < customers.length && techniqueEnd-techniqueStart < minutes){
                if(grumpy[techniqueEnd] == 1){
                    currentSatisfiedWithTechnique += customers[techniqueEnd];
                }
                techniqueEnd++;
            }
            maxSatisfiedWithTechnique = Math.max(maxSatisfiedWithTechnique, currentSatisfiedWithTechnique);
            if(grumpy[techniqueStart] == 0)
                satisfiedCustomersWithoutTechnique += customers[techniqueStart];
            else
                currentSatisfiedWithTechnique -= customers[techniqueStart];
            i++;
            j = techniqueEnd;
        }
        
        return maxSatisfiedWithTechnique + satisfiedCustomersWithoutTechnique; 
    }
}