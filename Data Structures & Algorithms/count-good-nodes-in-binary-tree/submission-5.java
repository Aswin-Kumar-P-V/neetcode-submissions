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
    private int goodNodesCount;
    public int goodNodes(TreeNode root) {
        this.goodNodesCount = 0;
        if(root == null) return goodNodesCount;
        calculateGoodNodes(root, Integer.MIN_VALUE);
        return goodNodesCount;
    }
    private void calculateGoodNodes(TreeNode node, int maxVal){
        if(node == null) return;
        if(node.val >= maxVal){
            goodNodesCount++;
        }
        int newMaxVal = Math.max(maxVal, node.val);
        calculateGoodNodes(node.left, newMaxVal);
        calculateGoodNodes(node.right, newMaxVal);
    }
}
