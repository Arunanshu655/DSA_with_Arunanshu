// Topics: Binary Search Tree

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public static int makeSumNode(Node root, int sum){
        if(root == null) return 0;
        
       
        int greaterSum = makeSumNode(root.right,sum);
        int lesserSum = makeSumNode(root.left,sum + greaterSum + root.data);
        int val = root.data;
        root.data = greaterSum + sum;
        return (greaterSum + lesserSum + val);
    }
    public static void transformTree(Node root) {
        // code here
        makeSumNode(root,0);
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(n);
