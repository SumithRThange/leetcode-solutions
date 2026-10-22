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
    private int preorderindex = 0;
    private Map <Integer, Integer> inorderMap = new HashMap<>(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }

        int rootvalue = preorder[preorderindex++];
        TreeNode root = new TreeNode(rootvalue);

        int mid = inorderMap.get(rootvalue);
        root.left = buildTree(preorder, left, mid-1);
        root.right = buildTree(preorder, mid+1, right);

        return root;
    }
}