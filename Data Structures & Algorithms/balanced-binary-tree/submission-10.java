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
    private boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalance;
    }
    private int dfs(TreeNode node){
        if(node == null) return -1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(Math.abs(left - right) > 1) isBalance = false;
        return 1 + Math.max(left, right);
    } 
}
