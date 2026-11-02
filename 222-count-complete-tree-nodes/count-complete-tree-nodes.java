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
    int lh = 0, rh = 0;
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
      lh = leftheight(root);
       rh = rightheight(root);
       if(lh == rh){
       return  (int)Math.pow(2, lh + 1) -1;
       } else {
        return 1 + countNodes(root.left) + countNodes(root.right);
       }
    }
    
    private int leftheight(TreeNode root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    private int rightheight(TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}