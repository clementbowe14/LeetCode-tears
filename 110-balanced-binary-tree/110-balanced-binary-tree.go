/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    if root == nil {
        return true
    }
    left := dfs(root.Left)
    right := dfs(root.Right)
    diff := int(math.Abs(float64(right - left)))
    return isBalanced(root.Left) && isBalanced(root.Right) && diff <= 1
}

func dfs(root *TreeNode) int {
    if root == nil {
        return 0
    }
    left := dfs(root.Left)
    right := dfs(root.Right)
    if left > right {
        return 1 + left
    }
    return 1 + right
}