// Topics: Tree, Depth-First-Search, Binary-Tree

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
    public int diameter = 0;
    public int findDia(TreeNode root){
        if(root == null) return 0;

        int left = findDia(root.left);
        int right = findDia(root.right);

        diameter = Math.max(diameter,left+right);

        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return diameter;
    }
}


// Time Complexity: O(n);
// Auxiliar Space: O(h);
