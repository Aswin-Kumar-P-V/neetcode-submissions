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
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        checkBalance(root);
        return isBalance;
    }
    private int checkBalance(TreeNode node){
        if(node == null) return -1;
        int left = checkBalance(node.left);
        int right = checkBalance(node.right);
        if(Math.abs(left - right) > 1) isBalance = false;
        return 1 + Math.max(left, right);
    }
}
