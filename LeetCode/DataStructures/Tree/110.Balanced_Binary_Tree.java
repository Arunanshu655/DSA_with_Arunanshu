// Topics: Tree, Depth-First-Search, Binary-tree

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
    public boolean balanced = true;
    public int findHeightDiff(TreeNode root){
        if(root == null) return 0;
        int left = findHeightDiff(root.left);
        int right = findHeightDiff(root.right);
        
        if(Math.abs(left-right)>1) balanced = false;
        return 1 + (Math.max(left,right));
    }
    public boolean isBalanced(TreeNode root) {
           findHeightDiff(root);
           return balanced;
    }
}


// Time Complexity: O(n);
// Auxiliary Space: O(h);
