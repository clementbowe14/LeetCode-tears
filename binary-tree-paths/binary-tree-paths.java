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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        DFS(root,ans,"");
        return(ans);
    }
    public void DFS(TreeNode root, List<String> ans, String current){
        if(root != null){
            if(root.left == null && root.right == null){
                current += root.val + "";
                ans.add(current);
                return; 
            }
            if(root.left != null){
                DFS(root.left,ans,current + root.val + "->");
            }
            if(root.right  != null){
                DFS(root.right, ans, current+root.val + "->");
            }
        }
    }
}