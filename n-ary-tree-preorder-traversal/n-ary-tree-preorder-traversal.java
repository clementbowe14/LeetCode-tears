/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        
        preorderTraversal(root, list);
        return list;
    }
    public void preorderTraversal(Node root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            
            for(int i = 0; i < root.children.size(); i++){
                preorderTraversal(root.children.get(i), list);
            }
        }
    }
}