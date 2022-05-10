class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), k, n, 1);
        return ans;
    }
    
    public void dfs(List<List<Integer>> A, List<Integer> C, int k, int n, int index) {
        if(k == 0) {
            if(n == 0) {
                A.add(new ArrayList<Integer>(C));
            }
        } else {
            
            for(int i = index; i <= 9; i++) {
                C.add(i);
                dfs(A, C, k-1, n-i, i+1);
                C.remove(C.size()-1);
            }
        }
        
    }
}