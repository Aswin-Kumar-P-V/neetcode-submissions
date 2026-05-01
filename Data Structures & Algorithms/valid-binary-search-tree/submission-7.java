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
    private List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i = 1; i < res.size(); i++){
            if(res.get(i-1) >= res.get(i)){
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
