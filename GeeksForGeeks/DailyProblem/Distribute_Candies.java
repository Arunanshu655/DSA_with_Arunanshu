// Topics: Tree

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int ans = 0;
    public int helper(Node root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        ans += (Math.abs(left) + Math.abs(right));
        
        return (root.data + left + right -1);
    }
    public int distCandy(Node root) {
        // code here
        helper(root);
        return ans;
        
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(h);
