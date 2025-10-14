// Topics: Tree

/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int nodeSum(Node root, int l, int r) {
        // code here
        if(root==null) return 0;
        int val = (root.data<=r && root.data>=l) ? root.data : 0;
        val += nodeSum(root.left,l,r);
        val += nodeSum(root.right,l,r);
        
        return val;
    }
}


// Time Complexity: O(n)
// Auxiliary Space: O(h)
