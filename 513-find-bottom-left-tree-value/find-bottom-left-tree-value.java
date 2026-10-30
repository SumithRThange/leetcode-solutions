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
    int leftval = 0, maxdepth = -1;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 0);
        return leftval;
    }
    private void findBottomLeftValue (TreeNode root, int level){
        if(root == null){
            return;
        } if(level > maxdepth){
            maxdepth = level;
            leftval = root.val;
        }
        findBottomLeftValue(root.left, level+1);
        findBottomLeftValue(root.right, level+1);
    }
}