// Topics: Traversal, Binary Search Tree

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
    public int countNodes(Node root){
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    int idx = 0;
    public int treeMedian(Node root,int n){
        if(root == null) return 0;
        int leftVal = treeMedian(root.left,n);
        if(idx==(n+1)/2) return leftVal;
        idx++;
        if(idx==(n+1)/2) return root.data;
        
        return treeMedian(root.right, n);
        
    }
    public int findMedian(Node root) {
        // Code here
        int n = countNodes(root);
        return treeMedian(root, n);
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(h)
