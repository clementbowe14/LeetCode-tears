class Solution {
    public int minSetSize(int[] arr) {
        int[] freq = new int[arr.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        
        for(int key: map.keySet()){
            freq[map.get(key)]++;
        }
        int total = 0;
        int count = 0;
        int start = arr.length;
        while(count < arr.length/2){
            while(start > 0 && freq[start] == 0 )
                start--;
            freq[start]--;
            count += start;
            total++;
        }
        return total;
    }
}