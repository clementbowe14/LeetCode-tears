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
    int totalCoins = 0;
    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        dfs(root);
        return totalCoins;

    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        totalCoins += Math.abs(left);
        
        int right = dfs(root.right);
        totalCoins += Math.abs(right);
        
        int ans = left + right + root.val-1;
        
        return ans;
    }
}