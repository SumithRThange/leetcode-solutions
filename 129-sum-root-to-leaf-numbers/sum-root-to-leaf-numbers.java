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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int total = 0;
        Stack<Integer> sum = new Stack<>();
        Stack<TreeNode> path = new Stack<>();
        sum.push(root.val);
        path.push(root);
        while(!path.isEmpty()){
            TreeNode temp = path.pop();
            int tempval = sum.pop();
            if(temp.left == null && temp.right == null){
                total += tempval;
            } if(temp.left != null){
                path.push(temp.left);
                sum.push(tempval * 10 + temp.left.val);
            } if(temp.right != null){
                path.push(temp.right);
                sum.push(tempval * 10 + temp.right.val);
            }
        }
        return total;
    }
}