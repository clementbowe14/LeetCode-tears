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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return constructTreeHelper(nums, 0, nums.length-1);
    }
    
    public TreeNode constructTreeHelper(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        
        int index = 0;
        int value = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++) {
            if(nums[i] > value) {
                value = nums[i];
                index = i;
            }
        }
        
        TreeNode node = new TreeNode(value);
        
        node.left = constructTreeHelper(nums, left, index-1);
        node.right = constructTreeHelper(nums, index+1, right);
        
        return node;
    }
}