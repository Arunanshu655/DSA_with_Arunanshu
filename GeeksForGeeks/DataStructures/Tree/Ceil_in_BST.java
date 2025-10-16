// Topics: Binary Search Tree

/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    
    int findCeil(Node root, int x) {
        // code here
        if(root == null) return -1;
        if(root.data<x) return findCeil(root.right,x);
        else if(root.data==x) return x;
        int val = findCeil(root.left,x);
        if(val != -1  && val>=x) return val;
        
        return root.data;
    }
}

// Time Complexity: O(logn);
// Auxiliary Space: O(logn);
