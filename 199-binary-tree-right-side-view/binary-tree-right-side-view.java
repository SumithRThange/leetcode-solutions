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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> treenode = new ArrayList<>();
        rightview (root, treenode, 0);
        return treenode;
    }
    private void rightview (TreeNode root, List<Integer> treenode, int level){
        if(root == null)
        return ;
        if(level == treenode.size()){
            treenode.add(root.val);
        }
        rightview(root.right, treenode, level + 1);
        rightview(root.left,treenode, level + 1);
        
    }
}