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
    int pre_index = 0;
    Map<Integer, Integer> inorderM = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderM.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length -1);
    }

    private TreeNode dfs(int[] preorder, int l , int r){
        if(l > r) return null;
        int val = preorder[pre_index];
        pre_index++;
        TreeNode root = new TreeNode(val);
        int mid = inorderM.get(val);
        root.left = dfs(preorder, l , mid - 1);
        root.right = dfs(preorder, mid+1, r);
        return root;
    }
}
