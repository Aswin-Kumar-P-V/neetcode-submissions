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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    private int goodNodes(TreeNode node, int maxVal){
        if(node == null) return 0;
        int res = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(node.val, maxVal);
        res += goodNodes(node.left, maxVal);
        res += goodNodes(node.right, maxVal);
        return res;
    }
}
