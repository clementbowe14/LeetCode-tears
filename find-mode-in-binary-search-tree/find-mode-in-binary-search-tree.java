/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxOccurrences = 0;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> ans = new ArrayList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == maxOccurrences){
                ans.add(i);
            }
        }
        int [] foo = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            foo[i] = ans.get(i);
        }
        return foo;
    }
    public void dfs(TreeNode root, Map<Integer,Integer> map){
        if(root != null){
            map.put(root.val, map.getOrDefault(root.val, 0)+1);
            maxOccurrences = Math.max(maxOccurrences, map.get(root.val));
            
            dfs(root.right, map);
            dfs(root.left, map);
        }
    }
}