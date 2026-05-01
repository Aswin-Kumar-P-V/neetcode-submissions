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
    private boolean isBalancedflag;
    public boolean isBalanced(TreeNode root) {
        isBalancedflag = true;
        isBalancedCheck(root);
        return isBalancedflag;
    }
    private int isBalancedCheck(TreeNode node){
        if(node == null) return -1;
        int left = isBalancedCheck(node.left);
        if(!isBalancedflag){
            return -2;
        }

        int right = isBalancedCheck(node.right);
        if(!isBalancedflag){
            return -2;
        }

        if(Math.abs(left-right) > 1){
            isBalancedflag = false;
        }

        return 1 + Math.max(left, right);
    }
}
