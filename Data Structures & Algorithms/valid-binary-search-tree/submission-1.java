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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, res);
        boolean isValid = true;
        for(int i = 1; i < res.size(); i++){
            if(res.get(i) <= res.get(i-1)){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    private TreeNode dfs(TreeNode node, ArrayList<Integer> res){
        if(node == null) return null;
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
        return node;
    }
}
