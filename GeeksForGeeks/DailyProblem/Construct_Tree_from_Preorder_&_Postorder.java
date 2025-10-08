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
    private int preIdx = 0;
    public Node constructTree(int[] pre, int[] post) {
        // code here
        return helper(pre,  post, 0, post.length - 1);
    }
    
    public Node helper(int[] pre, int[] post, int postSt, int postEnd){
        if(postSt>postEnd) return null;
        
        Node root = new Node(pre[preIdx++]);
        if(postSt==postEnd) return root;
        
        int i ;
        for(i = postSt; postSt<=postEnd; i++)
        if(post[i]==pre[preIdx]) break;
        
        root.left = helper(pre, post, postSt, i);
        root.right = helper(pre, post, i+1, postEnd-1);
        
        return root;
    }
}


// Time Complexity: O(n^2);
// Auxiliary Space: O(1)
